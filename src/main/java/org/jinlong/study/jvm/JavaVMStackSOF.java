package org.jinlong.study.jvm;

/**
 * VM args: -Xss161k 设置java虚拟机栈的单个线程请求的最大虚拟机栈
 * 虚拟机没有参数来设置总的虚拟机栈大小，在windows下，系统为单个进程分配的最大可用内存为2GB，
 * 因此虚拟机栈的大小=2GB - Xmx（最大堆容量） - MaxPermSize（最大方法去容量） - 程序计数器所占内存（很小，可以忽略不计）
 */
public class JavaVMStackSOF {

    private static int depth = 0;

    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable e) {
            System.out.println(depth);
            e.printStackTrace();
        }
    }
    public static void test() {
        depth++;
        test();
    }
}
