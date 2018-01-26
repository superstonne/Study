package org.jinlong.study.patterns.creational.factory;

public class AbstractFactory {

    public static void main(String[] args) {
        FruitFactory greenFactory = new GreenFruitFactory();
        System.out.println(greenFactory.createApple());
        System.out.println(greenFactory.createPear());

        FruitFactory redFactory = new RedFruitFactory();
        System.out.println(redFactory.createApple());
        System.out.println(redFactory.createPear());
    }


}

interface Apple {}
interface Pear {}
class GreenApple implements Apple {}
class GreenPear implements Pear {}
class RedApple implements Apple {}
class RedPear implements Pear {}
interface FruitFactory {
    Apple createApple();
    Pear createPear();
}
class GreenFruitFactory implements FruitFactory {
    @Override
    public Apple createApple() {
        return new GreenApple();
    }

    @Override
    public Pear createPear() {
        return new GreenPear();
    }
}
class RedFruitFactory implements FruitFactory {

    @Override
    public Apple createApple() {
        return new RedApple();
    }

    @Override
    public Pear createPear() {
        return new RedPear();
    }
}
