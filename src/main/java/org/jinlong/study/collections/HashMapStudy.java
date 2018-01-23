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
        HashMap hashMap = new HashMap(5,2);
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, i);
        }


        System.out.println(hashMap);
    }

}
