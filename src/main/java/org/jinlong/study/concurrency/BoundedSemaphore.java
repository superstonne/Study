package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class BoundedSemaphore {

    private int signal;
    private int bound;

    public BoundedSemaphore(int bound) {
        this.bound = bound;
    }

    public synchronized void take() throws InterruptedException {
        while (this.signal == bound) {
            wait();
        }
        this.signal++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.signal == 0) {
            wait();
        }
        this.signal--;
        notify();
    }
}
