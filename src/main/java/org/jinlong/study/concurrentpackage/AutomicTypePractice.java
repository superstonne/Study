package org.jinlong.study.concurrentpackage;

import java.util.concurrent.atomic.*;

/**
 * Created by nick on 31/05/2017.
 *
 * Java atomic 包提供了一系列的原子类型的类：AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference,
 * AtomicStampedReference, AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
 *
 * 所有的这些原子类都拥有set 和 get 方法，他们的工作原理和 volatile 类似，就是说 set 方法 与它之后的调用的 get 方法遵守
 * happens-before 原则，JVM不可以对这些操作进行重排序。同时compareAndSet 也一样具有内存一致性特性的。
 *
 */
public class AutomicTypePractice {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean setStatus1 = atomicBoolean.compareAndSet(true, false);
        System.out.println(setStatus1);
        boolean setStatus2 = atomicBoolean.compareAndSet(false, false);
        System.out.println(setStatus2);

        AtomicInteger atomicInteger = new AtomicInteger(100);
        atomicInteger.decrementAndGet();
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());

        AtomicLong atomicLong = new AtomicLong(100);
        atomicLong.getAndIncrement();
        System.out.println(atomicLong.get());

        AtomicReference<String> atomicReference = new AtomicReference<String >();
        atomicReference.set("a reference");
        System.out.println(atomicReference.get());
        System.out.println(atomicReference.compareAndSet("a reference", "a new reference"));

        String ref = null;
        int stamp = 0;
        /**
         * AtomicStampedReference 可以检测A-B-A问题根据判断当前的reference和stamp的内容是否相等。
         */
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(ref, stamp);
        String reference = atomicStampedReference.getReference();
        System.out.println(atomicStampedReference.getStamp());

        int[] array = new int[10];
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        System.out.println(atomicIntegerArray.get(8));

        long[] longArr = new long[10];
        AtomicLongArray atomicLongArray = new AtomicLongArray(longArr);
        System.out.println(atomicLongArray.get(4));

        Object[] objects = new Object[10];
        AtomicReferenceArray referenceArray = new AtomicReferenceArray(objects);
        System.out.println(referenceArray.get(0));

    }
}
