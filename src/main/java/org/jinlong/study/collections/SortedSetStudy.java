package org.jinlong.study.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by nick on 24/05/2017.
 * SortedSet作为Set的子接口
 * TreeSet 可以调用descendingIterator方法来返回一个倒序的迭代器来遍历集合中的元素
 */
public class SortedSetStudy {

    public static void main(String[] args) {

        TreeSet set = new TreeSet();
        set.add("ele 1");
        set.add("ele 3");
        set.add("ele 2");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = set.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
