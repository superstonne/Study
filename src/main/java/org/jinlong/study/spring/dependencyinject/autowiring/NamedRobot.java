package org.jinlong.study.spring.dependencyinject.autowiring;

public class NamedRobot extends Robot {
    private String name;
    private String gender;

    public NamedRobot(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void say() {
        System.out.println("My name is " + name + " and i am a " + gender);
    }
}
