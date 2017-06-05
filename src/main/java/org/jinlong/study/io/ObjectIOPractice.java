package org.jinlong.study.io;

import java.io.*;

/**
 * Created by nick on 05/06/2017.
 *
 * Object I/O 主要负责将可序列化的对象的二进制数据写入流中，或者将流中的数据读回Object。
 * 使用Object IO的类必须实现序列化接口。
 * 实现序列接口最好定义序列化属性，当一个类有重大的改动的时候最好也同时将序列化ID更改掉，这样存储在硬盘的上的旧版本的序列化类就不会
 * 被反序列化回来。
 *
 * 然而现在的序列化技术已经比Java官方提供的方式好用很多了，例如Json，Bson等等。
 */
public class ObjectIOPractice {
    private static class Person implements Serializable {
        int age;
        String name;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.bin"));
        Person p = new Person();
        p.age = 100;
        p.name = "Taiyizhenren";
        objectOutputStream.writeObject(p);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.bin"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person.name);
        objectInputStream.close();
        objectOutputStream.close();
    }
}
