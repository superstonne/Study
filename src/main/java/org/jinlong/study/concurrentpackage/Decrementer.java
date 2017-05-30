package org.jinlong.study.concurrentpackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 30/05/2017.
 */
public class Decrementer implements Runnable{
    private CountDownLatch countDownLatch;

    public Decrementer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.countDown();
            TimeUnit.SECONDS.sleep(3);
            countDownLatch.countDown();
            TimeUnit.SECONDS.sleep(3);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Latch has been removed.");

    }
}
