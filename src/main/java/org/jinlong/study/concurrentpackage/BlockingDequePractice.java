package org.jinlong.study.concurrentpackage;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by nick on 30/05/2017.
 * BlockingDeque 继承自 BlockingQueue, 比起 BlockingQueue更灵活的是，它是一个双向队列，所有BlockingQueue有的方法它都拥有，
 * 而且提供了俩个方法：头部操作和尾部操作
 * Java提供了一个实现类：LinkedBlockingDeque
 */
public class BlockingDequePractice {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque blockingDeque = new LinkedBlockingDeque(1024);
        blockingDeque.put(1);
        blockingDeque.offer(1);
        blockingDeque.putFirst(2);
        blockingDeque.take();
        blockingDeque.takeFirst();

    }
}
