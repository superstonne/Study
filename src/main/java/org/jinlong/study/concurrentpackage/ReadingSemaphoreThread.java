package org.jinlong.study.concurrentpackage;

import java.util.concurrent.Semaphore;

/**
 * Created by nick on 31/05/2017.
 */
public class ReadingSemaphoreThread extends Thread {
    private Semaphore semaphore;

    public ReadingSemaphoreThread(Semaphore semaphore) {
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
        System.out.println("Signal has been read.");
        semaphore.release();
    }
}
