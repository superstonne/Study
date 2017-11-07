package org.jinlong.study.java8.interfaces;

public interface Interface2 {
    void method2();
    default void log(String str) {
        System.out.println("I1 logging: " + str);
    };
}
