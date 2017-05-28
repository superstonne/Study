package org.jinlong.study.concurrency;

/**
 * Created by nick on 28/05/2017.
 */
public class Semaphore {
    private boolean signal = false;

    public synchronized void take() {
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!this.signal) {
            wait();
        }
        this.signal = false;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        ReceiveThead receiveThead = new ReceiveThead(semaphore);
        SendingThead sendingThead = new SendingThead(semaphore);
        receiveThead.start();
        sendingThead.start();
    }
 }
