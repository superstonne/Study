package org.jinlong.study.concurrentpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 31/05/2017.
 * <p>
 * ThreadPoolExecutor作为ExecutorService接口的实现类，它有个重要的属性：
 * corePoolSize： 如果线程池中的数量少于该值并且有新的任务提交进来时候，线程池会创建新的线程，即使池中有空闲的线程。
 * maximumPoolSize： 如果内部任务队列满了，并且正在运行的线程数多于corePoolSize但是少于maximumPoolSize，
 * 线程池将会创建新的线程来执行任务
 */
public class ThreadPoolExecutorPractice {

    public static void main(String[] args) {

        /**
         * 除非我们需要精确定制这些参数，否则使用Executors的工厂方法会更加方便。
         */
        int corePoolSize = 5;
        int maximumPoolSize = 1000;
        long keepAliveTime = 5000;
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    }
}
