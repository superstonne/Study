package org.jinlong.study.concurrentpackage;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nick on 30/05/2017.
 */
public class Waiter implements Runnable {
    private CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Go on process since latch missing.");

    }
}
