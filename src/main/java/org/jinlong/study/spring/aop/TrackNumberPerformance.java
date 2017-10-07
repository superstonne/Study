package org.jinlong.study.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrackNumberPerformance {

    public void perform(int trackNumber) {
        System.out.println("performing...");
    }
}
