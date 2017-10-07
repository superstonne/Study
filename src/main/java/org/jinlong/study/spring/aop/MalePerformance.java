package org.jinlong.study.spring.aop;

import org.springframework.stereotype.Component;

@Component(value = "malePerformance1")
public class MalePerformance implements Performance {
    public void perform() {
        System.out.println("Male performing...");
    }
}
