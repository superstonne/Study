package org.jinlong.study.concurrentpackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 30/05/2017.
 */
public class Producer implements Runnable{

    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            queue.put(1);
            TimeUnit.SECONDS.sleep(1);
            queue.put(2);
            TimeUnit.SECONDS.sleep(1);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
