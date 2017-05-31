package org.jinlong.study.concurrentpackage;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 31/05/2017.
 */
public class SendingSemaphoreThread extends Thread {
    private Semaphore semaphore;

    public SendingSemaphoreThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Permits: " + semaphore.availablePermits());
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println("Signal has been sent.");
    }
}
