package org.jinlong.study.concurrentpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by nick on 30/05/2017.
 *
 * ConcurrentMap 继承自 Map接口，可以并发的处理 get 和 put 操作元素。
 *
 * Java 提供了ConcurrentHashMap作为ConcurrentMap的实现类，和HashTable非常类似，但是ConcurrentHashMap提供了更好的性能。
 * ConcurrentHashMap在读取元素的时候不锁Map，在写入的时候同时不锁整个Map。
 * 同时ConcurrentHashMap 也不会抛出ConcurrentModificationException异常在迭代的Map的时候Map被更改调。
 *
 * Java concurrent包也提供了NavigableMap的实现类：ConcurrentNavigableMap
 * 同样该实现类提供了各个导航方法：headMap，subMap，tailMap，不同的是这些方法是可以并发执行的。
 * descendingMap，descendingKeySet，navigableKeySet
 *
 */
public class ConcurrentMapPractice {

    public static void main(String[] args) {
        ConcurrentMap concurrentMap = new ConcurrentHashMap();
        concurrentMap.put(1, "value1");
        concurrentMap.put(2, "value2");

    }
}
