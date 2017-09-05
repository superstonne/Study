package org.jinlong.study.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by nick on 07/06/2017.
 *
 * Java内存结构：
<<<<<<< HEAD
 * 堆内存，栈内存，方法区（永久区／元数据区）,本地方法栈，程序计数器
=======
 * 堆内存，栈内存，方法区（永久区／元数据区）
>>>>>>> origin/master
 *
 * 堆内存构成：
 * 新生代eden，幸存区survivor 2块，老年代
 * 使用VisualVM，Jprofiler，Jhat，Jmap，JConsole观察虚拟机堆信息
 *
 * 垃圾回收算法：
 * 1。 标记清除；缺点：内存碎片化，当给新的大对象分配内存时，如果内存不够会导致full gc。
 * 2。 复制； 缺点：内存浪费，因为任何时候都只能使用一半的内存。 优点：对内存来说，复制效率很高。 适用于新生代的幸存区的复制，
 *     因为存活对象少，复制效率高。
 * 3。 标记压缩； 缺点：效率低于复制算法。适用于老年代的回收，因为老年代垃圾少。
 *
 * JVM采用分代垃圾回收算法，新生代采用复制算法，老年代采用标记压缩算法。
 *
 * JVM 参数：
 * 1。 - 标准参数；例如：java -version
 * 2。 -X 非标准参数，每个JVM不同；
 * 3。 -XX 不稳定参数，有些版本的JVM可能没有该参数，下一个版本可能取消；
 *
 * JVM重的垃圾收集器：
<<<<<<< HEAD
 * 1。 Serial Collector 单线程收集器, 它在进行垃圾回收时会暂停所有用户进程，俗称stop the world。
 *                      同时它也是最简单高效的一款收集器为虚拟机运行在client模式下默认的垃圾回收器。
 *     ParNew Collector 它是Serial收集器的并行的版本，其他并无创新。它是目前新生代首选的收集器
=======
 * 1。 Serial Collector 单线程收集器
>>>>>>> origin/master
 * 2。 Parallel Collector 多线程收集器，并发量大，停顿时间长
 * 3。 CMS Collector 并发收集器，停顿时间短
 * 4。 G1收集器 不仅时间停顿短，同时并发量大
 *
 * Java对象的分配：
 * 1。 栈上分配：线程私有小对象；无逃逸，支持标量替换，无需调整；
 * 2。 线程本地分配： 占用eden，默认1%，小对象，多线程时候不用竞争eden就可以申请空间，提升效率；
 * 3。 老年代：大对象；
 * 4。 新生代 eden区
<<<<<<< HEAD
 *
 * GC日志规范：
 * [GC (Allocation Failure) [PSYoungGen: 1024K->496K(1536K)] 1024K->528K(5632K), 0.0008249 secs]
 * [垃圾回收的类型 [垃圾回收的区域: 回收前占用存储->回收后占用存储(该区域总存储)] 回收前堆内存占用存储->回收后堆内存占用(堆内存总存储), 该区域回收总耗时]
 *
 *
 */
public class JVMPractice {
    int i;

    public JVMPractice(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        Map objects = new HashMap();
        for (int i = 0; i < 100000000; i++) {
            objects.put(i, new JVMPractice(i));
        }
    }
}
