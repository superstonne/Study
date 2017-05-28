package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class SendingThead extends Thread {

    private Semaphore semaphore;

    public SendingThead(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        semaphore.take();
        System.out.println("Send signal");
    }
}
