package org.jinlong.study.jvm;

/**
 * String类的intern方法在JDK 1.6里面，如果调用时候，遇到的字符串没有在方法区的常量池
 * 中出现过，则会把它复制到常量池中。因为第一个判断在1.6的JDK中返回false,因为intern
 * 返回的是常量池中的string，str1则是存储在堆中的数据，因为不等。而在JDK1.7以后，JVM
 * 不会在进行这样的复制操作, 因此返回true。
 *
 * 第二个判断因为java字符串已经在常量池中出现过，所以在jdk 1.6 中不会进行复制操作。str2
 * 依然是堆内存中的数据，调用了intern方法返回的是常量池中的数据，因此不同的JDK版本均返回
 * false。
 */
public class StringPractice {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("java").append("").toString();
        System.out.println(str2.intern() == str2);
    }
}
