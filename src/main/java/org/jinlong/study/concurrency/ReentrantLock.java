package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class ReentrantLock {

    private boolean isLocked;
    private Thread lockedBy;
    private int lockCount;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && lockedBy != Thread.currentThread()) {
            wait();
        }
        isLocked = true;
        lockCount++;
        lockedBy = callingThread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockCount--;
        }
        if (lockCount == 0) {
            isLocked = false;
            notify();
        }
    }
}
