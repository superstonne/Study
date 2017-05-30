package org.jinlong.study.concurrentpackage;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by nick on 30/05/2017.
 * BlockingQueue 是java concurrent 包中的一个阻塞队列接口，它有如下实现类：
 *  1. ArrayBlockingQueue
 *  2. DelayQueue
 *  3. LinkedBlockingQueue
 *  4. PriorityBlockingQueue
 *  5. SynchronousQueue
 *
 * BlockingQueue接口主要提供了四类方法：
 *  1. throws exceptions type [add(o), remove(o), element()]
 *  2. Special value type [offer(o), poll(), peek()]
 *  3. Blocks type [put(o), take()]
 *  4. time out type [offer(o, timeout, timeunit), poll(timeout, timeunit)]
 *
 * BlockingQueue不允许插入Null，如果尝试插入Null，会报NullPointerException异常
 */
public class BlockingQueuePractice {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        /**
         *ArrayBlockingQueue基于数组实现，所以大小必须在初始化时候指定，之后不可以被更改；
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(100);
        arrayBlockingQueue.put("1");
        arrayBlockingQueue.put("2");


        /**
         *DelayQueue 基于PriorityQueue实现，容量无上限。获取的元素时候，如果元素还为超时则当前线程会block等待。
         */
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();
        DelayedElement delayedElement = new DelayedElement();
        delayQueue.put(delayedElement);
        delayQueue.take();

        /**
         * LinkedBlockingQueue 内部采用链式的数据结构存储元素，初始化时候可以给Queue初始化上限，也可以不初始化上限。
         * 如果不初始化上限，则最大元素存储个数为Integer.MAX_VALUE
         */
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.put("1");
        BlockingQueue boundedLinkedBlockingQueue = new LinkedBlockingQueue(1024);
        boundedLinkedBlockingQueue.put("2");

        /**
         * PriorityBlockingQueue 内部采取数组的存储结构，是一个平衡二叉堆的实现。插入Queue的元素必须实现Comparable接口。但是需要
         * 注意的是，如果使用迭代器遍历Queue中的元素，不保证元素。
         */
        System.out.println("*************PriorityBlockingQueue Test*******************");
        BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(1024);
        priorityBlockingQueue.put("1");
        priorityBlockingQueue.put("2");
        priorityBlockingQueue.put("3");
        priorityBlockingQueue.put("4");
        System.out.println("Size of PriorityBlockingQueue: " + priorityBlockingQueue.size());
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue.take());
        System.out.println("Size of PriorityBlockingQueue: " + priorityBlockingQueue.size());
        priorityBlockingQueue.put("2");
        priorityBlockingQueue.put("3");
        priorityBlockingQueue.put("1");
        priorityBlockingQueue.put("4");
        System.out.println("Iterator this Queue by Iterator");
        Iterator iterator = priorityBlockingQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*************PriorityBlockingQueue Test End*******************");

        /**
         * SynchronousQueue 作为BlockingQueue的实现，每次在Queue中只能容纳一个元素。
         * 当一个线程给SynchronousQueue插入元素时候该线程会阻塞直到有另外一个元素从Queue中将元素拿走。
         * 同时如果一个线程从Queue中取走元素时候，Queue中没有元素，当前线程会阻塞直到另一个线程给元素中
         * 插入元素。
         */
        BlockingQueue synchronousQueue = new SynchronousQueue();
//        synchronousQueue.put(1);
//        synchronousQueue.take();
//        synchronousQueue.put(2);
//        synchronousQueue.take();

    }
}
