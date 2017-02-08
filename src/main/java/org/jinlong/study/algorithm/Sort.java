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
            int flagIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[flagIndex] > arr[j]) {
                    flagIndex = j;
                }
            }
            int temp = arr[flagIndex];
            arr[flagIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 插入排序算法实现，从数组的第一位开始，按顺序每次取一个数字，然后与数组中当前索引之前的数字做比较，如果这个数字相比之下比较小，则互
     * 换位置，继续与再前一位数字比较直到当前数字不小于前面的数字。算法复杂度为N平方，若原数组近乎有序，则算法复杂度可以优化为N。
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
