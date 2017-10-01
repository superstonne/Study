package org.jinlong.study.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuperRobot extends Robot {
    private Robot sayHelloRobot;
    private Robot sayHiRobot;

    @Autowired
    public SuperRobot(Robot sayHelloRobot, Robot sayHiRobot) {
        this.sayHelloRobot = sayHelloRobot;
        this.sayHiRobot = sayHiRobot;
    }

    public void say() {
        sayHelloRobot.say();
        sayHiRobot.say();
    }
}
