package org.jinlong.study.concurrentpackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 30/05/2017.
 */
public class CyclicBarrierRunnable implements Runnable {
    private CyclicBarrier barrier1;
    private CyclicBarrier barrier2;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1.");
            barrier1.await();
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2.");
            barrier2.await();
            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
