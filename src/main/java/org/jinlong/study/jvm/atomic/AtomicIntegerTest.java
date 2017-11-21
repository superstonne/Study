package org.jinlong.study.jvm.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Field valueOffset = atomicInteger.getClass().getDeclaredField("valueOffset");
        valueOffset.setAccessible(true);
        System.out.println("valueOffset: " + valueOffset.get(atomicInteger));
        atomicInteger.set(0);
        System.out.println("valueOffset: " + valueOffset.get(atomicInteger));
        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor(null);
        unsafeConstructor.setAccessible(true);
        Unsafe unsafe = unsafeConstructor.newInstance();
        System.out.println(unsafe.getAndAddInt(atomicInteger, 12l, 0));

        atomicInteger.set(0);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(unsafe.compareAndSwapInt(atomicInteger, 12l, 0, 2));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    atomicInteger.set(atomicInteger.get() + 1);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    atomicInteger.set(atomicInteger.get() + 1);
//                }
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println(atomicInteger.get());
//        atomicInteger.set(0);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    atomicInteger.getAndIncrement();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    atomicInteger.getAndIncrement();
//                }
//            }
//        }).start();
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println(atomicInteger.get());

    }
}
