package org.jinlong.study.spring.dependencyinject.autowiring;

import javax.inject.Named;

@Named("sayHiRobot")
public class SayHiRobot extends Robot {
    public void say() {
        System.out.println("Hi everybody.");
    }
}
