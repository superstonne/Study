package org.jinlong.study.concurrentpackage;

import java.util.concurrent.Exchanger;

/**
 * Created by nick on 31/05/2017.
 */
public class ExchangeerRunnable implements Runnable {

    private Exchanger exchanger;
    private Object object;

    public ExchangeerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        Object previous = this.object;
        try {
            this.object = this.exchanger.exchange(this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exchange " + previous + " for " + this.object);

    }
}
