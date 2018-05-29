package org.jinlong.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunctionReferenceDemo {

    public static void main(String[] args) {

        // 构造方法引用
        Car car = Car.create(Car :: new);
        System.out.println(car);

        // 静态方法引用
        List<Car> cars = Arrays.asList(new Car("Car 1"), new Car("Car 2"));
        cars.forEach(Car :: fly);

        // 实例方法引用
        cars.forEach(Car :: sayName);

        //特殊类方法引用
        cars.forEach(car :: catching);
    }
}

class Car {
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }
    public void run() {
        System.out.println("Car is running.");
    }

    public static void fly(Car car) {
        System.out.println(car.name + " is flying.");
    }

    public void sayName() {
        System.out.println(this.name);
    }

    public void catching(Car car) {
        System.out.println(car.name + " is catching " + this.name);
    }

}
