package org.jinlong.study.collections;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * Created by nick on 24/05/2017.
 */
public class NavigableSetStudy {

    public static void main(String[] args) {

        NavigableSet set = new TreeSet();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(0);
        System.out.println(set);

        //调用set的descendingSet方法可以返回一个新的倒序的set，原始set的顺序并没有改变，descending set 结果相反
        NavigableSet reverse = set.descendingSet();
        System.out.println(reverse);
        System.out.println(set);

        //返回一个新的set，该set种所有元素小于参数元素，descending set 结果相反
        System.out.println(set.headSet(2, true));
        System.out.println(reverse.headSet(2));

        //返回一个新的set，该set种所有元素大于参数元素，descending set 结果相反
        System.out.println(set.tailSet(2));
        System.out.println(reverse.tailSet(2));

        //返回一个新的set，该set种所有元素在参数元素之间，包含左元素，descending set 结果相反
        System.out.println(set.subSet(0, 1));
        System.out.println(reverse.subSet(3, 0));

        //返回大于或者最靠近参数元素的元素，descending set 结果相反
        System.out.println(set.ceiling(3));
        System.out.println(reverse.ceiling(3));

        //返回小于或者最靠近参数的元素，descending set 结果相反
        System.out.println(set.floor(3));
        System.out.println(reverse.floor(3));

        //返回最靠近并且大于参数的元素，descending set 结果相反
        System.out.println(set.higher(2));
        System.out.println(reverse.higher(2));

        //返回最靠近并且小于参数的元素，descending set 结果相反
        System.out.println(set.lower(3));
        System.out.println(reverse.lower(2));

        //移除并且返回第一个元素，该操作似乎的现象似乎original和descending set 是同一个set
        System.out.println(set.pollFirst());
        System.out.println(set);
        System.out.println(reverse.pollFirst());
        System.out.println(reverse);

        //移除并且返回最后一个元素，该操作似乎的现象似乎original和descending set 是同一个set
        System.out.println(set.pollLast());
        System.out.println(set);
        System.out.println(reverse.pollLast());
        System.out.println(reverse);
    }
}
