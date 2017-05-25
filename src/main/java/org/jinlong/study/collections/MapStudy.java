package org.jinlong.study.collections;

import java.util.*;

/**
 * Created by nick on 25/05/2017.
 *
 * Map 接口不是Collection的子接口，它代表的是一组Key和Value的映射关系。
 *
 * Map的主要实现类有HashMap，TreeMap，HashTable，EnumMap，IdentityHashMap，LinkedHashMap， Properties，WeakHashMap
 *
 * 可以分别获取Map的key和value的迭代器来分别遍历Key和Value
 */
public class MapStudy {

    public static void main(String[] args) {
        Map a = new HashMap();
        Map b = new TreeMap();
        Map c = new Hashtable();
        Map d = new EnumMap(String.class);
        Map e = new IdentityHashMap();
        Map f = new LinkedHashMap();
        Map g = new Properties();
        Map h = new WeakHashMap();

        a.put("key1", "value1");
        a.put("key2", "value2");
        a.put("key3", "value3");

        String ele = (String) a.get("key1");
        System.out.println(ele);

        Iterator keyIterator = a.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = (String) keyIterator.next();
            System.out.println(key + " : " + a.get(key));
        }

        Iterator valueIterator = a.values().iterator();
        while (valueIterator.hasNext()) {
            System.out.println(valueIterator.next());
        }

        a.remove("key1");

        for (Object key : a.keySet()) {
            System.out.println(a.get(key));
        }
    }
}
