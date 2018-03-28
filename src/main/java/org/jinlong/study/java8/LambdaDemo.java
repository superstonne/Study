package org.jinlong.study.java8;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        final String common = ",";
        Arrays.asList("a", "b", "d").forEach(ele -> {
            System.out.println(ele + common);
        });

        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            return e1.compareTo(e2);
        });
        method(() -> System.out.println("Calling method1."));
    }

    public static void method(FunctionalMethod c) {
        c.method1();
    }
}


interface FunctionalMethod {
    void method1();

    default void method2() {
        System.out.println("default.");
    }

    static void method3() {
        System.out.println("static");
    }
}

