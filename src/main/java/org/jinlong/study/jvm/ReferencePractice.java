package org.jinlong.study.jvm;

import java.io.IOException;
import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 13/06/2017.
 *
 * VM options: -XX:+PrintGCDetails -Xms1m -Xmx1m 将虚拟机最大内存和初始化内存都设置为5M，并且打印GC详细信息
 *
 * Java 按照引用类型的强弱，将引用分为4类型：强引用，软引用，弱引用，虚引用
 *
 *
 */
public class ReferencePractice {
    public static Object global = null;
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 强引用
         * 类似于如下引用o等大多数程序中的引用是强引用，只要引用存在蓝记收集器就不会回收掉它指向的内存
         */
        Object o = new Object();

        ReferenceQueue queue = new ReferenceQueue();

        /**
         * 软引用
         * JDK1。2之后提供的SoftReference指向的引用为软引用，当JVM即将发生内存溢出时刻，会调用垃圾回收器
         * 来回收这一类软引用，当回收时候，内存请求仍然无法满足才会抛出内存溢出异常。软引用可以用于实现缓存
         * 技术，当内存不足时，JVM将删除这些缓存，同时我们也可以使得一些经常使用的缓存节点持有强引用，这样
         * 也可以避免内存不足时候这些节点被删除掉。运行下面的程序可以观察到JVM不会发生OOM异常，因为JVM内存
         * 不足时刻会回收掉这些软引用。通过VisualVM可以观察到Heap的使用率图表成有规律的锯齿形状。虚拟机的
         * 实现鼓励为优先清理最近创建和最近使用过的虚引用。{@linkSoftRefernce} 的timestamp用来记录该引用
         * 最近一次被使用的时间戳，垃圾回收器会使用该私有变量。
         */
//        while (true) {
//            SoftReference softReference = new SoftReference(new MyObject());
//        }


        /**
         * 弱引用
         * JDK1.2 提供的{@linkWeakReference} 是比软引用更弱的一种引用，如果没有强引用指向这个弱引用，那么
         * 它只能存活在下一次GC之前。它被用于创建一些很占用的内存的对象，这些对象又很容易被创建出来。
         * 运行如下代码会发现，过一会儿弱引用对象就被回收了。如果我们在<code>while</code> 循环里面加入对myObject
         * 的使用，则该弱引用不会被垃圾回收器回收掉。被回收掉时可以看到对象finalize方法被调用。
         */
        MyObject myObject = new MyObject();
        WeakReference weakReference = new WeakReference(myObject);
        while (true) {
//            System.out.println(myObject);
            if (weakReference.get() == null) {
                System.out.println("弱引用对象已经被回收。");
                break;
            } else {
                System.out.println("弱引用对象还是存在。");
            }
        }

        /**
         * 虚引用
         * 幽灵引用是最弱的一种引用，它在被创建以后，程序无法再获得它的引用，唯一的用途是它在被回收掉时会收到
         * 一个通知。这时候我们可以做一些清理工作。可以调用引用的isEnqueued方法来查看引用是否已经被回收掉。
         * 对象被回收掉时并没有看到finalize方法被执行。
         */
        PhantomReference phantomReference = new PhantomReference(new MyObject(), queue);
        while (true) {
            if (phantomReference.isEnqueued()) {
                phantomReference.clear();
                System.out.println("幽灵引用已经被回收");
                break;
            } else {
                System.out.println("幽灵依然存在");
            }
        }
        TimeUnit.SECONDS.sleep(10);

    }

    static class MyObject {
        byte[] bytes = new byte[1024 * 1024 * 10];

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize is called");
//            global = this;
        }
    }
}
