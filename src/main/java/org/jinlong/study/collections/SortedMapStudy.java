package org.jinlong.study.collections;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 * Created by nick on 25/05/2017.
 *
 * SortedMap作为Map的子接口，该容器中的元素是有序的。
 *
 * 同样可以调用TreeMap对象的descendingKeySet方法获得容器的逆序迭代器，倒序遍历容器。
 */
public class SortedMapStudy {

    public static void main(String[] args) {
        TreeMap map = new TreeMap();

        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");

        SortedSet descendingSet = map.descendingKeySet();

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }

        iterator = descendingSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }

    }
}
