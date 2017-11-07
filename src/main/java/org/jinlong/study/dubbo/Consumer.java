package org.jinlong.study.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/spring/dubbo-demo-cosumer.xml");
        applicationContext.start();
        DemoService demoService = applicationContext.getBean("demoService", DemoService.class);
        String hello = demoService.sayHello("world");
        System.out.println(hello);
    }
}
