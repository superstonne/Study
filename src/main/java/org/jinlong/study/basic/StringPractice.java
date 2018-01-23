package org.jinlong.study.basic;

import java.util.Date;

public class StringPractice {
    public static void main(String[] args) {
        String a = "";
        long start1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            a += "some data";
        }
        long end1 = new Date().getTime();
        System.out.println(end1 - start1);


        String b = "";
        long start2 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            b.concat("some data");
        }
        long end2 = new Date().getTime();
        System.out.println(end2 - start2);

        StringBuilder c = new StringBuilder();
        long start3 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            c.append("some data");
        }
        long end3 = new Date().getTime();
        System.out.println(end3 - start3);

    }
}
