package org.jinlong.study.algorithm;

/**
 * Created by nick on 07/02/2017.
 */
public class Sort {
    /**
     * 选择排序算法实现，从数组的第一位开始，每次选取一个数字，然后遍历数组，拿这个数字和数组中的每一个数字做比较，获取最小的数字，互换
     * 位置。则数组的长度N，算法复杂度为N平方。
     * @param arr 测试数组
     * @return 返回拍好顺序的结果。
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
