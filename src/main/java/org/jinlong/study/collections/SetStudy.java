package org.jinlong.study.collections;

import java.util.*;

/**
 * Created by nick on 24/05/2017.
 *
 * Set 作为Collection的子接口，所以Collection的所有方法同样适用于Set
 *
 * Set主要实现类有： HashSet，LinkedSet，TreeSet
 * 其中HashSet是无序的；LinkedHashSet和TreeSet可以保证元素的的顺序；
 * LinkedHashSet种的元素顺序为元素的插入顺序；而TreeSet种元素的顺序为实现Comparable接口种定义的顺序
 * 同样遍历Set的元素的方式有2种：
 * Iterater迭代器和增强for循环
 */
public class SetStudy {

    public static void main(String[] args) {
        Set a = new HashSet();
        Set b = new LinkedHashSet();
        Set c = new TreeSet();

        a.add("ele 1");
        a.add("ele 2");
        a.add("ele 3");
        System.out.println(a);

        //LinkedHashSet保证了元素的插入顺序
        b.add("ele 2");
        b.add("ele 1");
        b.add("ele 3");
        System.out.println(b);

        //TreeSet 保证了元素是有序的，但是没有保证元素的插入顺序，而是根据类的comprare方法比较的结果来维护顺序
        c.add("ele 2");
        c.add("ele 1");
        c.add("ele 3");
        System.out.println(c);


    }
}
