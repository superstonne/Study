package org.jinlong.study.spring;

public class Nest {
    private Animal animal;

    public Nest(Animal animal) {
        this.animal = animal;
    }

    public void sayName() {
        animal.sayName();
    }
}
