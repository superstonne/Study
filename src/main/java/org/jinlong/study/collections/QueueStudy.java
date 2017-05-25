package org.jinlong.study.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by nick on 25/05/2017.
 *
 * Queue作为Collection的子接口，因为Collection的所有特性同样适用于Queue。
 * Queue描述的是一种从尾部插入元素，头部移除元素的数据结构。
 *
 * Java提供了俩个普通的Queue实现类：LinkedList是一种标准的实现，PriorityQueue是一种带了排序功能Queue。
 *
 * 通过element方法获取Queue的头部元素，通过remove方法移除Queue的头部元素。
 *
 * 同样，遍历Queue有俩种方式，Iterator迭代器和增强for循环
 */
public class QueueStudy {

    public static void main(String[] args) {

        Queue a = new LinkedList();
        Queue b = new PriorityQueue();

        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(a.element());

        Iterator iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object o : a) {
            System.out.println(o);
        }

        System.out.println(a.remove());
    }
}
