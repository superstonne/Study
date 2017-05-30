package org.jinlong.study.concurrentpackage;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nick on 30/05/2017.
 */
public class CountDownLatchPractice {

    public static void main(String[] args) {

        /**
         * 初始化门闩的数量，waiter调用await方法使得当前线程阻塞等待门闩打开，decrementer调用countdown方法来减少门闩的数量
         * 当数量减少为0时候，waiter被唤醒继续执行。
         */

        CountDownLatch latch = new CountDownLatch(3);
        Thread decrementer = new Thread(new Decrementer(latch));
        Thread waiter = new Thread(new Waiter(latch));
        decrementer.start();
        waiter.start();
    }
}
