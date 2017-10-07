package org.jinlong.study.spring.dependencyinject;

public class Nest {
    private Animal animal;

    public Nest(Animal animal) {
        this.animal = animal;
    }

    public void sayName() {
        animal.sayName();
    }
}
