package org.jinlong.study.collections;

import java.util.*;

/**
 * Created by nick on 24/05/2017.
 *
 * Java集合分为2类：Collection 和 Map
 * 其中根接口为Collection，Iterable 和 Map
 *
 * Collection继承了Iterable接口，并且有三大子接口：List，Set，Queue；其次Set子接口：SortedSet；SortedSet 有 NavigableSet子接口；
 * Queue有Deque子接口；
 *
 * Map接口有SortedMap子接口，SortedMap 有 NavigableMap接口
 *
 * Collection 主要有add，addAll，remove，removeAll，retainAll方法
 * add和remove是负责添加对象到集合，如果传入的是集合对象，则会将集合对象添加或者移除而不是集合里面的每个元素
 * addAll和removeAll是负责将集合里面的每个元素加入或者移除到目标集合
 * retainAll的功能恰好和removeAll的功能相反，是负责移除所有目标集合种的元素除了参数集合中包含的元素
 *
 * 遍历Collection的方法有2种：
 * 1. 使用迭代器，调用Collection的iterator方法返回迭代器；使用hasNext方法，确认集合中是否仍有元素；使用next方法获取迭代器当前指向的
 *    元素，并且指针向后移动。
 * 2. 使用增强for循环遍历集合（数组和实现了Iterable接口的集合都可以使用增强for循环）
 *
 */
public class CollectionStudy {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(-1);
        list.add(-2);
        list.add(-3);
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(-1);
        collection.add(-1);
        collection.add(-1);
        collection.addAll(list);
        collection.add(list);
        System.out.println(collection);
        collection.remove(1);
        System.out.println(collection);
        System.out.println("Start to call retainAll");
        collection.retainAll(list);
        System.out.println(collection);
        collection.removeAll(list);
        System.out.println(collection);
        collection.addAll(list);
        System.out.println(collection.contains(-1));
        System.out.println(collection.containsAll(list));
        System.out.println(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
