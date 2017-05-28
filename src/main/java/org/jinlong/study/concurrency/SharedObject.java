package org.jinlong.study.concurrency;

/**
 * Created by nick on 27/05/2017.
 */
public class SharedObject {
    int count;
    MyLock lock = new MyLock();
    public void add() throws InterruptedException {
//        lock.lock();
        this.count++;
//        lock.unlock();
    }

    public void sub() throws InterruptedException {
//        lock.lock();
        this.count--;
//        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}
