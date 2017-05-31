package org.jinlong.study.concurrentpackage;


import java.util.concurrent.Semaphore;

/**
 * Created by nick on 31/05/2017.
 *
 * Java concurrent 包提供了一个counting semaphore的实现。
 * 线程可以通过acquire获得信号量，当信号量为0时候会被阻塞，通过release释放信号量
 *
 * 但是默认Semaphore是不保证公平的，除非初始化时候指定保证公平，但是这样会造成的性能的降低
 * Semaphore semaphore = new Semaphore(1, true)
 * */
public class SemaphorePractice {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        new SendingSemaphoreThread(semaphore).start();
        new ReadingSemaphoreThread(semaphore).start();

    }
}
