package org.jinlong.study.basic;

public class StringBuilderPractice {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("");
        System.out.println(builder.capacity());
        for (int i = 0; i < 100; i++) {
            builder.append(i);
            System.out.println(builder.capacity());
        }
    }
}
