package org.jinlong.study.algorithm;

import java.util.List;

/**
 * Created by nick on 02/01/2017.
 */
public class Util {
    /**
     * Print items to console.
     * @param list
     * @param <T>
     */
    public static <T> void  printListItems(List<T> list) {
        if (list == null) {
            return;
        }
        for (T t : list) {
            System.out.println(t);
        }
    }
}
