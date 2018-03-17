package org.jinlong.study.collections;

import java.util.*;

/**
 * Created by nick on 24/05/2017.
 *
 * List 接口的实现类有ArrayList，LinkedList，Vector，Stack
 *
 * List接口不同于Collection的地方有：
 *  1. 可以通过add（index， element）的方式向list种添加元素(此时参数index必须不大于当前list的size)，该方法加入的元素不会覆盖该位置
 *     已经存在的元素，会使得当前位置到之后的所有元素向list尾部移动一格
 *  2. 可以通过remove（index）来删除集合中的元素，此时该索引之后的所有元素向前移动一格
 *  3. List不但可以通过Iterator，增强for循环，还可以通过for （int i = 0； i < list.size(); i++ ）来迭代元素
 *  4. 可以同get（index）来获取特定索引的元素
 */
public class ListStudy {

    public static void main(String[] args) {
        List a = new ArrayList();
        List b = new LinkedList();
        List c = new Vector();
        List d = new Stack();

        a.add("object 1");
        a.add("object 2");
        a.add("object 3");
        System.out.println(a);

        a.add(0, "object 0");
        //IndexOutOfBoundsException
        //a.add(100, "object 100");
        System.out.println(a);

        System.out.println(a.get(0));

        Iterator iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object o : a) {
            System.out.println(o);
        }

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        a.remove("object 1");
        System.out.println(a);

        a.remove(0);
        System.out.println(a);

        a.clear();
        System.out.println(a);

        System.out.println(a.size());

        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            System.out.println(list.size());
        }

    }
}
