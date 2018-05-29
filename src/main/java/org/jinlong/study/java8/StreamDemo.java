package org.jinlong.study.java8;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        int sumWithOut5 = list.stream()
                .filter(integer -> integer.intValue() > 5)
                .mapToInt(Integer :: intValue)
                .sum();
        System.out.println(sumWithOut5);
    }
}
