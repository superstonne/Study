package org.jinlong.study.spring.dependencyinject.test;

import junit.framework.TestCase;
import org.jinlong.study.spring.dependencyinject.autowiring.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RobotXMLTest extends TestCase {

    ClassPathXmlApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void testSimpleBeanInit() {
        SayHelloRobot sayHelloRobot = (SayHelloRobot) context.getBean("sayHelloRobot");
        Assert.assertNotNull(sayHelloRobot);
        SayHiRobot sayHiRobot = (SayHiRobot) context.getBean("sayHiRobot");
        Assert.assertNotNull(sayHiRobot);
        SuperRobot superRobot = (SuperRobot) context.getBean("superRobot");
        Assert.assertNotNull(superRobot);
        SuperRobot superRobot2 = (SuperRobot) context.getBean("superRobot2");
        Assert.assertNotNull(superRobot2);
        NamedRobot namedRobot = (NamedRobot) context.getBean("namedRobot");
        namedRobot.say();
        NamedRobot namedRobot1 = (NamedRobot) context.getBean("namedRobot1");
        namedRobot1.say();
        NamedRobot namedRobot2 = (NamedRobot) context.getBean("namedRobot2");
        namedRobot2.say();
        ManyNamesRobot manyNamesRobot = (ManyNamesRobot) context.getBean("manyNamesRobot");
        manyNamesRobot.say();
        ManyNamesRobot manyNamesRobot1 = (ManyNamesRobot) context.getBean("manyNamesRobot2");
        manyNamesRobot1.say();
    }
}
