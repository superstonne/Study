package org.jinlong.study.collections;

import java.util.*;

/**
 * Created by nick on 25/05/2017.
 *
 * NavigableMap 作为SortedMap的子接口，有了更多的功能。
 *
 * Java只提供了TreeMap一种NavigableMap作为实现。
 *
 * 通过ceilingKey，floorKey，higherKey，lowerKey；
 * ceilingEntry，floorEntry，higherEntry，lowerEntry；
 * pollFirstEntry，pollLastEntry来分别去除第一个或者最后一个元素
 */
public class NavigableMapStudy {

    public static void main(String[] args) {
        NavigableMap map = new TreeMap();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        NavigableSet reverseKeySet = map.descendingKeySet();
        NavigableMap reverseMap = map.descendingMap();

        SortedMap head = map.headMap("key2");

        SortedMap tail = map.tailMap("key2");

        SortedMap sub = map.subMap("key1", "key2");

        Object key1 = map.ceilingKey("key1");
        Object key2 = map.floorKey("key2");
        Object key3 = map.higherKey("key1");
        Object key4 = map.lowerKey("key1");

        Map.Entry entry1 = map.ceilingEntry(1);
        Map.Entry entry2 = map.floorEntry(1);
        Map.Entry entry3 = map.higherEntry(1);
        Map.Entry entry4 = map.lowerEntry(1);

        map.pollFirstEntry();
        map.pollLastEntry();
    }
}
