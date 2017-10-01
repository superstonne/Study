package org.jinlong.study.spring.autowiring;

import javafx.beans.NamedArg;
import org.jinlong.study.spring.autowiring.Robot;

import javax.inject.Named;

@Named("sayHiRobot")
public class SayHiRobot extends Robot {
    public void say() {
        System.out.println("Hi everybody.");
    }
}
