package org.jinlong.study.concurrency;

/**
 * Created by nick on 27/05/2017.
 *
 * This is not a fair lock, maybe cause starvation
 */
public class MyLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread hasn't lock this lock!");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}
