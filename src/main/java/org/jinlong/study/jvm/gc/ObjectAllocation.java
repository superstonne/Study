package org.jinlong.study.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * JVM args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:SurvivorRatio=8 调整Eden和Survivor区域的比例
 * 1。 对象优先在新生代的Eden区分配
 * 在下面的例子中，JVM设置了如上参数，此时Eden的区域内存为8M，from，to survivor的区域的内存分别为1M，
 * 因此新生代的总可用内存是9M。当给allocation4分配内存时候发现，新生代只剩下3M内存，不够分配，此时会
 * 发生一次Minor GC。但此时对象都是存活的，因此to survivor区域无法容纳前三个对象，则使用分配担保机制，
 * 这三个对象直接进入老年代。allocation4分配内存在Eden区域。
 *
 * 2。大对象直接在老年代分配内存
 * 当对象需要的内存大于Eden的内存时候会直接在老年代分配内存。或者可以使用参数-XX：PretenureSizeThreshold=number（bytes）
 * 来限制对象大于该阀值时候直接分配到老年代。
 *
 * 3。长期存活的对象将进入老年代
 * JVM为对象设置了一个年龄参数，每当对象经过一次Minor GC，那么对象的年龄+1。
 * 默认当一个对象15岁时候进入老年代，可以通过参数-XX:MaxTenuringThreshold=1来控制对象多大年龄可以进入老年代
 *
 * 4。同样的年龄的对象的内存加起来大于to survicor 的一半容量，则将大于该年龄的所有对象移动到老年代
 * 此时对象的并不需要一定等到达到年龄阀值才能进入老年代
 */
public class ObjectAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        sameAgeObjectSizeMoveedToTenureGen();
    }

    public static void allocateObjectOnEdenFirst() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 加入参数-XX:PretenureSizeThreshold=3145728
     * 该参数只适用于Serial和ParNew俩款收集器
     * 代表当一个对象所需的内存大于3MB的时候，直接在老年代分配内存。
     */
    public static void allocateBigObjectOnOldGenDirectly() {
        byte[] allocation = new byte[9 * _1MB];
    }

    /**
     *使用-XX:MaxTenuringThreshold=年龄 来控制对象多大时候进入老年代
     */
    public static void oldObjectWouldBeMovedToTenureGen() throws Exception {
        byte[] allocation1 = new byte[_1MB /4];
        byte[] allocation2 = new byte[_1MB * 4];
        byte[] allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];
    }

    /**
     * 同样的年龄的对象的内存加起来大于to survicor 的一半容量，则将大于该年龄的所有对象移动到老年代
     */
    public static void sameAgeObjectSizeMoveedToTenureGen() {
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation4 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[_1MB * 4];
        byte[] allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];
    }
}
