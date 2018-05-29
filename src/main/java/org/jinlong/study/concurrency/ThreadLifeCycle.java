package org.jinlong.study.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {

        //1。 线程进入初始化状态。
        Thread thread = new Thread(() -> {
            System.out.println("Thread has been started.");
        });

        //2。 线程进入就绪状态（join，sleep方法结束也会进入就绪状态，调用yield方法也会进入就绪状态），注意：调用run方法不会启动新的线程，
        // run方法只是一个普通的方法会被线程启动后调用。
        thread.start();

        // 线程的start方法只可以被调用一次，否则会跑出IllegalThreadStateException
        //thread.start();

        //3。线程被OS调度运行时，线程进入运行状态。

        //4. 调用sleep线程进入阻塞状态，此外还有join，System.in.read()等阻塞方法的调用; 注意: 阻塞状态下，线程的不会释放Monitor对象。
        thread.sleep(10);
        thread.join();


        //5。 线程run方法执行完毕后，线程终止。


    }
}
