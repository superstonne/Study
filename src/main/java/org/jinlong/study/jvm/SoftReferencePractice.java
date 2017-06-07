package org.jinlong.study.jvm;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 13/06/2017.
 *
 * VM options: -XX:+PrintGCDetails -Xms1m -Xmx1m 将虚拟机最大内存和初始化内存都设置为5M，并且打印GC详细信息
 *
 * Java 按照引用类型的强弱，将引用分为4类型：强引用，软引用，弱引用，虚引用
 *
 *
 */
public class SoftReferencePractice {
    public static void main(String[] args) {
        SoftReferencePractice a = new SoftReferencePractice();
        System.gc();
    }
}
