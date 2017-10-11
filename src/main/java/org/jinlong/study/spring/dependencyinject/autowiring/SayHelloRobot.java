package org.jinlong.study.spring.dependencyinject.autowiring;

import org.springframework.stereotype.Component;

@Component("sayHelloRobot")
public class SayHelloRobot extends Robot {

    public void say() {
        System.out.println("Hello everybody.");
    }
}
