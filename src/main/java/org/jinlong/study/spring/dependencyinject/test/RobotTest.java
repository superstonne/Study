package org.jinlong.study.spring.dependencyinject.test;

import org.jinlong.study.spring.dependencyinject.autowiring.Robot;
import org.jinlong.study.spring.dependencyinject.config.RobotConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= RobotConfig.class)
public class RobotTest {
    @Autowired
    private Robot sayHelloRobot;
    @Autowired
    private Robot notSayHello;
    @Inject
    private Robot sayHiRobot;

    @Autowired
    private Robot superRobot;

    @Test
    public void testEqualSayHello() {
        Assert.assertEquals(sayHelloRobot, notSayHello);
    }

    @Test
    public void robotNotNull() {
        Assert.assertNotNull(sayHelloRobot);
    }

    @Test
    public void sayHiRobotNotNull() {
        Assert.assertNotNull(sayHiRobot);
    }

    @Test
    public void testSuperRobotNotNull() {
        Assert.assertNotNull(superRobot);
    }

    @Test
    public void testSuperRobot() {
        superRobot.say();
    }
}
