package org.jinlong.study.concurrentpackage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by nick on 31/05/2017.
 *
 * ExecutorService 是java并发包提供的一个线程池接口，它有如下实现类：
 * ThreadPoolExecutor, ScheduledThreadPoolExecutor
 */
public class ExecutorServicePractice {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 1!");
            }
        });
        System.out.println(future.get());

        Future future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 2!");
            }
        });
        /**
         * 如果submit提交的任务正常结束，那么Future会获得一个null
         */
        System.out.println(future2.get());

        /**
         * 除了使用submit提交任务，还可以使用execute提交，不同点在于execute提交的任务没有返回值。
         */
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 3!");
            }
        });

        /**
         * If your want task return a specific result, you can submit a Callable instance to the thread pool.
         */
        Future future4 = executorService.submit(new Callable() {
            @Override
            public Object call() {
                System.out.println("Executing callable 4!");
                return "Result for callable!";
            }
        });
        System.out.println(future4.get());
        /**
         * 调用shutdown方法发送关闭命令给线程池，不在接受新任务的提交。
         * 如果继续提交任务，则会抛出RejectedExecutionException异常。
         * 接收到关闭指令后，线程池不会立马终止，它会等待所有已经提交的任务执行完毕后，关闭线程池。
         * 如果你想立刻关闭线程池，则必须调用shutDwonNow方法，该方法传递关闭命令给线程池，线程池收到指令后
         * 会去停止正在执行的任务，跳过已经提交但是还没有被执行的任务。对于正在执行的任务的结果不保证，有可能是
         * 异常终止，也有可能是正常结束。
         */
//        executorService.shutdown();
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Executing runnable!");
//            }
//        });

        /**
         * 接下来我们可以是invokeAny去提交一批任务到线程池，这些任务中只有一个任务会被执行，返回结果也只有一个。
         * 当有一个任务已经结束或者出现异常，其他所有任务都将被取消掉。
         */
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String> () {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 1 executed!");
                return "Callable 1";
            }
        });
        callables.add(new Callable<String> () {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 2 executed!");
                return "Callable 2";
            }
        });
        callables.add(new Callable<String> () {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 3 executed!");
                return "Callable 3";
            }
        });
        String result = executorService.invokeAny(callables);
        callables.add(new Callable<String> () {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 4 executed!");
                return "Callable 4";
            }
        });
        System.out.println("result: " + result);

        /**
         * 执行集合中的所有任务
         */
        executorService.invokeAll(callables);
        executorService.shutdown();

    }
}
