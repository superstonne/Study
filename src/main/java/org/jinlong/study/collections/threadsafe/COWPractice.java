package org.jinlong.study.collections.threadsafe;

import java.util.concurrent.CopyOnWriteArrayList;

public class COWPractice {

    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(new Integer[10]);
        for (int i = 0; i < 100; i++) {
            copyOnWriteArrayList.add(i);
        }
        System.out.println(copyOnWriteArrayList.toArray().length);
    }
}
