package org.jinlong.study.patterns.creational.factory;

import org.jinlong.study.spring.dependencyinject.Animal;
import org.jinlong.study.spring.dependencyinject.Cat;
import org.jinlong.study.spring.dependencyinject.Dog;
import org.jinlong.study.spring.dependencyinject.Nest;

public class SimpleFactory {

    public static Animal getAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(SimpleFactory.getAnimal("dog"));
        System.out.println(SimpleFactory.getAnimal("cat"));
    }
}
