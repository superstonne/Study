package org.jinlong.study.concurrency.unsafe;

import org.junit.Assert;
import sun.misc.Unsafe;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UnsafeTest {
    public static void main(String[] args) throws Exception {
        // 自己编写的程序不可以使用此方法来获得Unsafe对象，调用会抛出SecurityException
        try {
            Unsafe.getUnsafe();
        } catch (SecurityException e) {
            System.out.println("You can't get Unsafe instance.");
        }

        // 我们可以使用反射来获取Unsafe的实例，查看源码可能它的实例存储在theUnSafe 私有变量。
        // 但是不同的JDK实现这个存储变量可能不同，例如Android存储在THE_ONE

        // 1. 通过属性获取Unsafe实例
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);

        // 2. 通过构造器获得Unsafe实例, 该种方法通用语其他平台，例如Android
        Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Unsafe unsafe1 = constructor.newInstance();
        System.out.println(unsafe1);

        // 通过Unsafe来创建一个类的实例不需要调用类和父类的构造方法
        ClassWithExpensiveConstructor expensiveConstructor =
                (ClassWithExpensiveConstructor) unsafe.allocateInstance(ClassWithExpensiveConstructor.class);
        Assert.assertEquals(0, expensiveConstructor.getValue());

        // 使用Object的构造器来构造ClassWithExpensiveConstructor
        Constructor<ClassWithExpensiveConstructor> silentConstructor =
                (Constructor<ClassWithExpensiveConstructor>) ReflectionFactory.getReflectionFactory().newConstructorForSerialization(ClassWithExpensiveConstructor.class
                , Object.class.getConstructor());
        silentConstructor.setAccessible(true);
        Assert.assertEquals(0, silentConstructor.newInstance().getValue());

        // 使用OtherClass的构造器来初始化ClassWithExpensiveConstructor
        Constructor<ClassWithExpensiveConstructor> silentConstructor1 =
                (Constructor<ClassWithExpensiveConstructor>) ReflectionFactory.getReflectionFactory().newConstructorForSerialization(ClassWithExpensiveConstructor.class
                        , OtherClass.class.getDeclaredConstructor());
        silentConstructor1.setAccessible(true);
        ClassWithExpensiveConstructor instance = silentConstructor1.newInstance();
        Assert.assertEquals(10, instance.getValue());
        Assert.assertEquals(ClassWithExpensiveConstructor.class, instance.getClass());
        Assert.assertEquals(Object.class, instance.getClass().getSuperclass());

        // 利用Unsafe申请堆外内存，进而获得一个大于Integer.MAX_VALUE的数组
        long maximum = Integer.MAX_VALUE + 1L;
        DirectIntArray directIntArray = new DirectIntArray(maximum);
        directIntArray.setValue(0L, 10);
        directIntArray.setValue(maximum, 20);
        Assert.assertEquals(10, directIntArray.getValue(0L));
        Assert.assertEquals(20, directIntArray.getValue(maximum));
        directIntArray.destroy();

    }
}
