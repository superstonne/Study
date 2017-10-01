package org.jinlong.study.spring.config;

import org.jinlong.study.spring.autowiring.Robot;
import org.jinlong.study.spring.autowiring.SayHelloRobot;
import org.jinlong.study.spring.autowiring.SayHiRobot;
import org.jinlong.study.spring.autowiring.SuperRobot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
//@ComponentScan(basePackages = {"org.jinlong.study.spring.autowiring"})
//@ComponentScan(basePackageClasses = {Robot.class})
public class RobotConfig {

    @Bean(name = {"notSayHello", "sayHelloRobot"})
    public SayHelloRobot sayHelloRobot() {
        return new SayHelloRobot();
    }
    @Bean
    public SayHiRobot sayHiRobot() {
        return new SayHiRobot();
    }

    @Bean
    public SuperRobot superRobot() {
        return new SuperRobot(sayHelloRobot(), sayHiRobot());
    }

    @Bean
    public SuperRobot superRobot(SayHelloRobot sayHelloRobot, SayHiRobot sayHiRobot) {
        return new SuperRobot(sayHelloRobot, sayHiRobot);
    }

    @Bean
    public Robot getSayHelloRobot() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SayHelloRobot();
        } else if (choice == 1) {
            return new SayHiRobot();
        } else if (choice == 2) {
            return new SuperRobot(sayHelloRobot(), sayHiRobot());
        } else {
            return new Robot() {
                @Override
                public void say() {
                    System.out.println("No name robot.");
                }
            };
        }
    }
}
