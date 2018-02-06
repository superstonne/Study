package org.jinlong.study.basic;

public class StringBufferPractice {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sayName();
    }
}
 class Animal {
    void sayName() {
        System.out.println("I'm animal.");
        sayHello();
    }
    void sayHello() {
        System.out.println("Hello from animal.");
    }
}

class Dog extends Animal {
    @Override
    void sayName() {
        System.out.println("I'm a dog.");
        super.sayName();
    }

    @Override
    void sayHello() {
        System.out.println("Hello from dog.");
    }
}
