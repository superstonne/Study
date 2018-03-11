package org.jinlong.study.concurrentpackage;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWHashMap extends HashMap{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    @Override
    public Object put(Object key, Object value) {
        writeLock.lock();
        Object object = super.put(key, value);
        writeLock.unlock();
        return object;
    }

    @Override
    public Object get(Object key) {
        readLock.lock();
        Object o = super.get(key);
        readLock.unlock();
        return o;
    }
}
