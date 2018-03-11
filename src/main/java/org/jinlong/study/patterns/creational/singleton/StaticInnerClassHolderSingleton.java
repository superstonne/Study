package org.jinlong.study.patterns.creational.singleton;

public class StaticInnerClassHolderSingleton {

    private static class InstanceHolder {
        private final static StaticInnerClassHolderSingleton instance = new StaticInnerClassHolderSingleton();
    }

    private StaticInnerClassHolderSingleton() {
    }

    public static StaticInnerClassHolderSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
