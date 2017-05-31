package org.jinlong.study.concurrentpackage;

import java.util.concurrent.*;

/**
 * Created by nick on 31/05/2017.
 * ScheduledExecutorService作为ExecutorService的子接口，它可以控制内部的任务延迟执行，或者给定一个间隔时间
 * 循环的执行。
 * 它的实现类有：ScheduledThreadPoolExecutor
 */
public class ScheduledExecutorServicePractice {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Scheduled task had been executed!");
                return "Scheduled Results.";
            }
        },
        5, TimeUnit.SECONDS);

        /**
         * 使用scheduleAtFixedRate方法来提交一个循环执行的任务。Delay参数描述的是第一次执行任务的延迟时间。
         * 如果任务的执行时间超过了间隔时间，那么下次执行将会在本次结束后开始，保证不会俩次的任务同时执行。
         */
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Executed at per 2 seconds!");
//            }
//        },2, 2, TimeUnit.SECONDS);

        /**
         * 使用scheduleWithFixedDelay 提交循环执行的任务。Period描述的情况于scheduleAtFixedRate不同，with描述的时间段为previous
         * task 结束的时间到，next task开始的时间。然而at描述的是previous task开始的时间到，next task开始的时间，区别仅此而已。
         */
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executed at per 2 seconds!");
            }
        },4, 1, TimeUnit.SECONDS);

        /**
         * 同样在最后需要调用shutdown方法来终止JVM, 调用shutdown会终止循环执行的任务。
         */
//        scheduledExecutorService.shutdown();

    }
}
