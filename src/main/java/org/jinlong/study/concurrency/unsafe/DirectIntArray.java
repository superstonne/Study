package org.jinlong.study.concurrency.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DirectIntArray {
    private final static long INT_SIZE_IN_BYTES = 4;
    private final long startIndex;
    private Unsafe unsafe;
    public DirectIntArray(long size) throws Exception {
        Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        unsafe = constructor.newInstance();
        this.startIndex = unsafe.allocateMemory(size * INT_SIZE_IN_BYTES);
        unsafe.setMemory(startIndex, size * INT_SIZE_IN_BYTES, (byte) 0);
    }

    private long index(long offset) {
        return startIndex + offset * INT_SIZE_IN_BYTES;
    }

    public void destroy() {
        unsafe.freeMemory(startIndex);
    }

    public void setValue(long index, int value) {
        unsafe.putInt(index(index), value);
    }

    public int getValue(long index) {
        return unsafe.getInt(index(index));
    }
}
