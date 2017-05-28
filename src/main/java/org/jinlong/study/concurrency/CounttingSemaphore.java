package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class CounttingSemaphore {

    private int signal;

    public synchronized void take() {
        this.signal++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.signal == 0) {
            wait();
        }
        this.signal--;
    }
}
