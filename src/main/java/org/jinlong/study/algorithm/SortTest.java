package org.jinlong.study.algorithm;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 07/02/2017.
 * 测试排序算法
 */
public class SortTest {

    public static void main(String[] args) throws Exception {
        int[] data1 = generateNearlySeqArray(100000, 100000, 10);
        int[] data2 = copyArray(data1);
        executeSort("selectionSort", data1);
        executeSort("insertionSort", data2);
    }

    /**
     * 执行需要调用的排序算法
     * @param sortMethodName 排序算法的名字
     * @param data 测试数据
     * @return
     * @throws Exception
     */
    public static int[] executeSort(String sortMethodName, int[] data) throws Exception{
        Class sortClass = Class.forName("org.jinlong.study.algorithm.Sort");
        Method sortMethod = sortClass.getMethod(sortMethodName, int[].class);
        long startTime = new Date().getTime();
        int[] result = (int[]) sortMethod.invoke(sortClass, data);
        long endTime = new Date().getTime();
        double duration = (endTime - startTime) / 1000d;
        System.out.println(sortMethodName + ": " + duration + " S");
        return result;
    }

    /**
     * 生成测试的随机数组
     * @param length 数组长度
     * @param range 数组中的最大数字
     * @return
     */
    public static int[] generateRandomArray(int length, int range) {
        int[] array = new int[length];
        Random random = new Random(47);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }
    public static int[] generateNearlySeqArray(int length, int range, int swapTimes) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Random random = new Random(47);
        for (int i = 0; i < swapTimes; i++) {
            int swapIndex = random.nextInt(range);
            int temp = array[swapIndex];
            array[swapIndex] = array[range - swapIndex];
            array[range - swapIndex] = temp;
        }
        return array;
    }

    /**
     * 打印数组中的每一个变量
     * @param arr 数组
     */
    public static void printArray(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int a : arr) {
            builder.append(a);
            builder.append(" ");
        }
        System.out.println(builder.toString());
    }

    public static int[] copyArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
