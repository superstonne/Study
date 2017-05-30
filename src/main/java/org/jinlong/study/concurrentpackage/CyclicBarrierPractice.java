package org.jinlong.study.concurrentpackage;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by nick on 30/05/2017.
 *
 * CyclicBarrier 是一个篱笆，它可以挡住一定数量的线程，直到所有线程都到达当前篱笆时候才统一开始执行，同时可以设置篱笆的等待
 * 超时时间。
 */
public class CyclicBarrierPractice {

    public static void main(String[] args) {
        Runnable barrier1Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 1 executed!");
            }
        };
        Runnable barrier2Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 2 executed!");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable runnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable runnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
        new Thread(runnable1, "Thread 1").start();
        new Thread(runnable2, "Thread 2").start();
    }
}
