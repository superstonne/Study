package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class ReceiveThead extends Thread {

    private Semaphore semaphore;

    public ReceiveThead(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received signal");
    }
}
