package org.jinlong.study.jvm;

import java.util.concurrent.atomic.AtomicInteger;

            /**
             * volatile不可保证线程安全案例，因为++操作在虚拟机内部不是原子操作。
             * 虚拟机将++操作编译为了四条指令：
             * 0： getstatic  将race的值取到操作数栈顶（由可见性保证，可以取到正确的数据）
             * 3： iconst_1
             * 4： iadd
             * 5： putstatic
             * 但是在执行后面的指令的时候，race的值有可能已经被其他线程改变了，
             * 因此putstatic可能将错误的数据写回主内存
             */
            public class VolatileTest {

                public static volatile int race = 0;

                public static void increase() {
                    race++;
                }

                public static final int THREADS_COUNT = 10;

                public static void main(String[] args) {
                    Thread[] threads = new Thread[THREADS_COUNT];
                    for (int i = 0; i < THREADS_COUNT; i++) {
                        threads[i] = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 10; i++) {
                                    increase();
                                }
                                System.out.println("over.");
                            }
                        });
                        threads[i].start();
                    }

                    while (Thread.activeCount() > 1) {
                        Thread.yield();

                    }
                    System.out.println(race);
                }
            }
