package org.jinlong.study.java8.interfaces;

public interface Interface1 {
    void method2();
    void methods1(String str);
    default void log(String str) {
        System.out.println("I1 logging: " + str);
    };
}
