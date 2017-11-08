package org.jinlong.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数设置: -XX:MaxMetaspaceSize=10m
 * JDK8中去掉了永久代的2个参数PermSize和PermMaxSize，新加了MaxMetaspaceSize参数用于指定
 * 元数据区域可以申请的操作系统的最大内存，方法不在占用虚拟机内存
 * 常量池的内存也不占用堆内存，直接申请操作系统内存，因此此处设置最大元数据内存
 * 并不会抛出OOM异常
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
