package org.jinlong.study.patterns.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式适用于，对同一个集合的数据，当我们有多个维度不同处理方式的时候。添加新的访问方式和新的元素，无需修改源代码，符合开闭原则。
 */
public class VisitorDemo {

    public static void main(String[] args) {
        NameVisitor nameVisitor = new NameVisitor();
        AgeVisitor ageVisitor = new AgeVisitor();

        AnimalList list = new AnimalList();
        list.addAnimal(new People("Nick1", 10));
        list.addAnimal(new People("Nick2", 11));
        list.addAnimal(new People("Nick3", 13));
        list.addAnimal(new People("Nick4", 15));
        list.addAnimal(new People("Nick5", 14));

        list.accept(nameVisitor);
        list.accept(ageVisitor);
        System.out.println(nameVisitor.names);
        System.out.println(ageVisitor.age);

    }

}

abstract class Visitor {
    abstract void visit(Animal animal);
}

class NameVisitor extends Visitor {
    StringBuilder names = new StringBuilder();
    @Override
    void visit(Animal animal) {
        names.append(animal.getName());
    }
}

class AgeVisitor extends Visitor {
    int age = 0;
    @Override
    void visit(Animal animal) {
        age += animal.getAge();
    }
}

abstract class Animal {

    protected String name;

    private int age;

    public Animal() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void accept(Visitor visitor);
}

class People extends Animal {

    public People(String name, int age) {
        super(name, age);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AnimalList {
    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }

    public void accept(Visitor visitor) {
        for (Animal animal : animals) {
            animal.accept(visitor);
        }
    }
}


