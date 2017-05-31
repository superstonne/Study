package org.jinlong.study.concurrentpackage;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by nick on 31/05/2017.
 * ForkJoinPool 是java7新加的一个类，它可以把一个大任务拆分成若干个小任务，然后放到不同的CPU去执行，最后再把结果合并起来。
 *
 * 可以添加俩类任务到ForkJoinPool
 * RecursiveAction 类型没有返回值
 * RecursiveTask 类型有返回值
 */
public class ForkJoinPoolPractice {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
//        forkJoinPool.invoke(new MyRecursiveAction(1024));

        long result = forkJoinPool.invoke(new MyRecursiveTask(128));
        System.out.println("Merged result: " + result);
    }
}
