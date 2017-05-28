package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class ReadWriteLock {

    private int writers;
    private int readers;
    private int writingRequest;

    public synchronized void lockRead() throws InterruptedException {
        if (writers > 0 || writingRequest > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notify();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writingRequest++;
        if (writers > 0 || readers > 0) {
            wait();
        }
        writingRequest--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notify();
    }
}
