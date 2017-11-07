package org.jinlong.study.dubbo.provider;

import org.jinlong.study.dubbo.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
