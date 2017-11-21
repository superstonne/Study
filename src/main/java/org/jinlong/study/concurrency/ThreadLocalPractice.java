package org.jinlong.study.concurrency;

/**
 * Created by nick on 19/06/2017.
 */
public class ThreadLocalPractice {

    private static int num;
    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override protected Integer initialValue() {
            return 0;
        }
    };

    private static Increment increment = new Increment();

    private static ThreadLocal<Increment> incrementThreadLocal = new ThreadLocal<Increment>() {
        @Override protected Increment initialValue() {
            return increment;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    num++;
                    System.out.println(Thread.currentThread().getName() + " Num= " + num);
                    int localNumber = local.get();
                    localNumber++;
                    local.set(localNumber);
                    System.out.println(Thread.currentThread().getName() + " Local Num= " + localNumber);

                    Increment increment = incrementThreadLocal.get();
                    increment.increase();
                    incrementThreadLocal.set(increment);
                    System.out.println(Thread.currentThread().getName() + " Increment Local Num= " + increment.num);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class Increment {
        static int num;
        synchronized void increase() {
            num++;
        }
    }
}
