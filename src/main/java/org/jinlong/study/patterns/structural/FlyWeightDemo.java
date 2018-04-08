package org.jinlong.study.patterns.structural;

public class FlyWeightDemo {
    public static void main(String[] args) {
        // String 类使用了享元设计模式
        String a = "abcd";
        String b = "abcd";
        String c = "ab" + "cd";
        String d = "ab";
        d += "cd";
        String e = new String("abcd");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(d);
    }
}
