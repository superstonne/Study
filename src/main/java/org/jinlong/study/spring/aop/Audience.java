package org.jinlong.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* org.jinlong.study.spring.aop.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones...");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats...");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Clip Clip Clip.");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund.");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("before performance start");
            joinPoint.proceed();
            System.out.println("after performance end");
        } catch (Throwable throwable) {
            System.out.println("demanding a refund.");;
        }
    }
}
