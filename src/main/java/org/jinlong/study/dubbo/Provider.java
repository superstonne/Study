package org.jinlong.study.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("META-INF/spring/dubbo-demo-provider.xml");
        applicationContext.start();
        System.in.read();
    }
}
