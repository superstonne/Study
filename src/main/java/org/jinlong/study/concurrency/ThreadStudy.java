package org.jinlong.study.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 27/05/2017.
 *
 *  多线程带来的坏处：
 *   1。 使得程序设计变得更复杂，程序设计中要考虑共享变量的读写同步问题。
 *   2。 上下文切换的代价更大，CPU需要保存线程的局部变量，程序指针等。
 *   3。 增加了资源的消耗，需要更多的内存来保存线程的本地栈。
 *
 *  多线程带来的好处：
 *   1。 更好的资源利用率。
 *   2。 在一些场景下，可以使得程序设计更加简单。
 *   3。 响应更及时的应用程序。
 *
 *   Java并发模型
 *    1。 Parallel Model（并行并发模型）
 *      优势：容易理解，更多的工作只需要多家worker线程就可以了
 *      弊端：共享状态（业务数据，数据缓存，连接池，数据库）变得更加复杂；各个线程的执行顺序不确定；每次都需要重新拿状态；
 *    2。 Event driven Model （事件驱动并发模型）典型的案例：Actor（直接和actor交互），Channel（通过频道进行交互）
 *      优势：无共享状态，不需要维护并发共享状态；性能更好因为不需要维护状态；工作顺序是确定的；
 *      弊端： 代码可读性不好，需要写很多回调函数。
 *    3。 Functional Parallelism（函数并行并发模型）典型案例：Java 7 ForkAndJoinPool，java8 stream
 *
 *   Java Memory Model
 *   Java内存模型指定了JVM和内存的工作方式，决定了线程之前读写共享变量的方式，如何使得共享变量保持同步。
 *
 *   Synchronized
 *   Volatile 修饰的变量存储在主存RAM中，保证了变量的Visibility和Happens before
 *
 *   Visibility：
 *   每一次Volatile变量的读取都在主存中，每一次的写入同样在主存中，而不是CPU的缓存。
 *   Volatile变量的读和写指令不可以被JVM重排序，其他指令为了性能考虑，JVM会进行重排序。
 *
 *   Happens-before：
 *   当一个线程更改了Volatile变量后，不止Volatile变量要写回主存，更改Volatile变量之前更改的其他变量也要写回主存。
 *   同时，当一个线程要读取Volatile变量时候，不仅仅从主存读取Volatile变量，要同时读取和Volatile一起被写入主存的
 *   其他变量。
 *
 *
 *   sharedObject.nonVolatile1 = 123;
     sharedObject.nonVolatile2 = 456;
     sharedObject.nonVolatile3 = 789;

     sharedObject.volatile     = true; //a volatile variable

     int someValue1 = sharedObject.nonVolatile4;
     int someValue2 = sharedObject.nonVolatile5;
     int someValue3 = sharedObject.nonVolatile6;

     JVM可以重排序前三三句指令和后三句指令，但是绝不可以把Volatile前面的指令拍到写后面，也绝不可以把写后面的指令重排序到写之前。

     读和写到主存是非常昂贵的，而且volatile阻止了JVM的指令重排序，所以volatile要在你确实很需要的时候使用。

     不要用字符串变量来当锁，因为JVM把常量字符串翻译为同样的对象。因此，当其他的对象的字符串被上锁使，该对象的字符串和其他对象的字符串
     对象一样，也即被上锁了。
 *
 *    死锁的解决方法：
 *    1。规定获取所得顺序；前提是你知道所有锁
 *    2。锁超时机制；得自己定制锁类
 *    3。死锁检测；需要将线程对锁的请求记录下来分析
 *
 *    饥饿和公平：
 *    1。 优先级的高的线程无限制占用CPU资源，导致低优先级线程无法得到运行机会；
 *    2。 线程永久的被阻塞，因为其他线程总是可以在它之前拿到锁；
 *    3。 线程永久的被阻塞，因为其他线程总是在它之前被唤醒；
 *
 *   //Lock的正确使用方式
 *   lock.lock();
     try{
     //do critical section code, which may throw exception
     } finally {
     lock.unlock();
 }
 *
 */
public class ThreadStudy {

    private int count1;

    private static int count2;

    public static void main(String[] args) throws Exception{
        SharedObject sharedObject = new SharedObject();
        System.out.println(sharedObject.getCount());
        for (int i = 0; i < 1000; i++) {
            Thread t = new MyAddThread(sharedObject, "Thread" + i);
            t.start();
        }
//        Thread t = new MyAddThread(sharedObject);
//        t.start();
        TimeUnit.SECONDS.sleep(5);

        System.out.println(sharedObject.getCount());
    }

    //Lock is instance/ this
    public synchronized void add1() {
        this.count1++;
    }

    //Lock is TheadStudy.class
    public synchronized static void add2() {
        count2++;
    }

    public void add3() {

        synchronized (this) {
            this.count1++;
        }
    }

    public static void add4() {

        synchronized (ThreadStudy.class) {
            count2++;
        }
    }
}

class MyAddThread extends Thread {
    SharedObject sharedObject;

    public MyAddThread(SharedObject sharedObject, String name) {
        this.sharedObject = sharedObject;
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int sleep = random.nextInt(10);
            TimeUnit.MILLISECONDS.sleep(sleep);
            sharedObject.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class MySubThread extends Thread {
    SharedObject sharedObject;

    public MySubThread(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sharedObject.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
