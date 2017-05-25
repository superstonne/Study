package org.jinlong.study.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nick on 25/05/2017.
 *
 * Deque作为Queue的子接口，描述是一种可以从头和为都可以移除元素的数据结构
 *
 * Java提供俩个Deque的实现：ArrayDeque和LinkedList
 */
public class DequeStudy {

    public static void main(String[] args) {

        Deque a = new ArrayDeque();
        Deque b = new LinkedList();

        a.add(1);
        a.addFirst(2);
        a.addLast(3);
        System.out.println(a);

        System.out.println(a.element());
        System.out.println(a.getFirst());
        System.out.println(a.getLast());

        //同样，迭代器和增强for循环的遍历都适用于Deque

        a.removeFirst();
        a.removeLast();
        a.remove();
    }
}
