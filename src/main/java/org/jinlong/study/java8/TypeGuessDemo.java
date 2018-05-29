package org.jinlong.study.java8;


public class TypeGuessDemo {

    public static void main(String[] args) {
        GuessType<String> type = new GuessType<>();
        System.out.println(type.getOrDefault("22", GuessType.defaultValue()));
    }
}

class GuessType<T> {
    public static<T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
