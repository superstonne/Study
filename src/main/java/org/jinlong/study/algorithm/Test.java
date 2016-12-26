package org.jinlong.study.algorithm;

/**
 * Created by nick on 26/12/2016.
 */
public class Test {
    public static void main(String[] args) {
        TestObj obj1 = new TestObj();
        obj1.arr = new int[] {1, 2, 3};
        TestObj obj2 = new TestObj();
        obj2.arr = obj1.arr;
        obj2.arr[1] = 111;
        System.out.println(obj1);
        System.out.println(obj2);
    }

}


class TestObj {
    int[] arr;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) str.append(arr[i]);
        return str.toString();
    }
}