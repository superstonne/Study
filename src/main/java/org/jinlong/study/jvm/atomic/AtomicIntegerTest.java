package org.jinlong.study.jvm.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Field valueOffset = atomicInteger.getClass().getDeclaredField("valueOffset");
        valueOffset.setAccessible(true);
        System.out.println("valueOffset: " + valueOffset.get(atomicInteger));
        atomicInteger.set(100000000);
        System.out.println("valueOffset: " + valueOffset.get(atomicInteger));
        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor(null);
        unsafeConstructor.setAccessible(true);
        Unsafe unsafe = unsafeConstructor.newInstance();
        System.out.println(unsafe.getAndAddInt(atomicInteger, valueOffset.getLong(null), 0));
    }
}
