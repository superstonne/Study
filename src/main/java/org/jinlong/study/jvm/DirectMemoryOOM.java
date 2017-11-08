package org.jinlong.study.jvm;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * JVM 参数设置：-Xmx20M -XX:MaxDirectMemorySize=10M
 * 当程序无法申请到所需的操作系统直接内存时候，会抛出OOM异常
 * Mac操作系统下实验失败
 */
public class DirectMemoryOOM {
    private static final int  _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
