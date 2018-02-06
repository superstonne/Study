package org.jinlong.study.patterns.creational.factory;

import java.io.*;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Monkey monkey = new Monkey("Monkey1", 20);
        Monkey clonedMonkey = monkey.clone();
        System.out.println(monkey == clonedMonkey);
        System.out.println(monkey.getName() == clonedMonkey.getName());
        System.out.println(monkey.getName().equals(clonedMonkey.getName()));

        Monkey deepClonedMonkey = monkey.deepClone();
        System.out.println(monkey == deepClonedMonkey);
        System.out.println(monkey.getName() == deepClonedMonkey.getName());
        System.out.println(monkey.getName().equals(deepClonedMonkey.getName()));

        String a = "a";
        String b = "a";
        String c = new String("a");
        String d = new String("a");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
    }
}

class Monkey implements Cloneable, Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Monkey(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Monkey clone() throws CloneNotSupportedException {
        return (Monkey) super.clone();
    }

    public Monkey deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        return (Monkey) objectInputStream.readObject();
    }
}
