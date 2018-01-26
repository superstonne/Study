package org.jinlong.study.basic;

public class StringBufferPractice {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sayHello();

        Animal animal = new Animal();
        animal.sayHello();
    }

}

class Animal {
    void sayName() {
        System.out.println("I'm animal.");
    }

    void sayHello() {
        this.sayName();
        System.out.println(this);
        System.out.println("Hello from animal.");
    }
}

class Dog extends Animal {
    @Override
    void sayName() {
        System.out.println("I'm dog.");
    }

    @Override
    void sayHello() {
        System.out.println(super.toString());
        super.sayHello();
    }
}
