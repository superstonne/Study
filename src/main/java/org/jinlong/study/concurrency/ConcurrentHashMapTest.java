package org.jinlong.study.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1, 1);
        map.get(1);
        map.put(2, 2);
        map.get(2);
    }
}
