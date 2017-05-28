package org.jinlong.study.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 28/05/2017.
 *
 * 注意：enqueue和dequeue只有当size是0或者size为上限的时候才调用notifyAll，因为只有这时候才有可能有线程在等待写入或者读取。
 */
public class BlockingQueue {

    private List queue = new ArrayList();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object o) throws InterruptedException {
        while (this.queue.size() == limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(o);
    }

    public synchronized void dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == limit) {
            notifyAll();
        }
        this.queue.remove(0);
    }
}
