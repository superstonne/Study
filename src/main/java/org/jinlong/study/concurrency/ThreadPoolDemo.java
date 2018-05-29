package org.jinlong.study.concurrency;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        // 提交任务时候，如果线程数没有达到corePoolSize的数量，即使又空闲的线程，也会创建新的线程去执行任务。
        int corePoolSize = 10;

        // 提交任务时候，如果线程数量已经大大到了corePoolSize并且缓存队列已经存满，那么继续增加线程数直到达到maxPoolSize
        int maxPoolSize = 15;

        // 提交任务时候，当线程数达到了corePoolSize，那么将任务混存在阻塞队列中
        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(5);


        // 线程空闲达到该时间后会销毁
        int keepAlive = 5;

        // 空闲时间单位
        TimeUnit unit = TimeUnit.MINUTES;


        // 构建线程的工厂指定
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable task) {
                if (task instanceof Task) {
                    return new Thread(task, ((Task)task).getName());
                } else {
                    return new Thread(task);
                }
            }
        };


        // 当最大线程数量和缓存队列都满了以后的拒绝策略
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                5,
                unit,
                blockingQueue,
                factory,
                rejectedExecutionHandler
        );

        for (int i = 0; i < 100; i++) {
            poolExecutor.execute(new Task("Task " + i));
        }
        System.out.println("Finished.");

    }
}

class Task implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread" + Thread.currentThread().getName() + " is started.");
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread" + Thread.currentThread().getName() + " is stopped.");
    }
}
