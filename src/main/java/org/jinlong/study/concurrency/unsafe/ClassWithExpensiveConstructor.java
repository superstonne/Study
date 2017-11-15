package org.jinlong.study.concurrency.unsafe;

public class ClassWithExpensiveConstructor {

    private final int value;

    private ClassWithExpensiveConstructor() {
        value = doExpensiveLookup();
    }

    private int doExpensiveLookup() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int getValue() {
        return value;
    }
}
