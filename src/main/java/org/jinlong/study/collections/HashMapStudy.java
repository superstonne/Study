package org.jinlong.study.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by nick on 25/05/2017.
 * 1。 HashMap允许Null Key 和 Null Vlaue
 * 2。 HashMap不保证元素的顺序
 * 3。 HashMap的搜索时间复杂度是O（1）
 *
 */
public class HashMapStudy {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("dog", "狗");
        hashMap.put("pig", "猪");
        hashMap.put("banana", "香蕉");
        hashMap.put("apple", "苹果");
        hashMap.put("watermelon", "西瓜");

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
