package org.jinlong.study.collections;

import java.util.Stack;

/**
 * Created by nick on 25/05/2017.
 *
 * Stack作为List的实现类，其实表现形式和List不是很一致。Stack描述的是LIFO数据结构，恰好和Queue相反，XML解析非常适合使用Stack。
 *
 *使用push方法将元素放入栈内，pop将栈顶元素移除
 *
 * 使用search方法查找元素的索引
 */
public class StackStudy {

    public static void main(String[] args) {

        Stack a = new Stack();
        a.push(1);
        a.push(2);
        a.push(3);

        System.out.println(a);

        a.pop();

        System.out.println(a);

        System.out.println(a.search(1));
    }
}
