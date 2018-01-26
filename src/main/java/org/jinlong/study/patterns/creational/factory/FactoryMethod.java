package org.jinlong.study.patterns.creational.factory;


public class FactoryMethod {

    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        System.out.println(dogFactory.createAnimal());
        AnimalFactory catFactory = new CatFactory();
        System.out.println(catFactory.createAnimal());
    }
}



interface AnimalFactory {
    Animal createAnimal();
}

class DogFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

interface Animal {}

class Dog implements Animal {}
class Cat implements Animal {}