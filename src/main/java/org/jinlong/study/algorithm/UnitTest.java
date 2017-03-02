package org.jinlong.study.algorithm;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 07/02/2017.
 * 测试排序算法
 */
public class UnitTest {

    public static void main(String[] args) throws Exception {
        int[] data = Util.generateOrderedArray(200000, 200000);
//        data = generateNearlySeqArray(10000, 10000, 10);
        int[] data1 = Util.copyArray(data);
        int[] data2 = Util.copyArray(data);
        int[] data3 = Util.copyArray(data);
        int[] data4 = Util.copyArray(data);
//        executeSort("selectionSort", data1);
//        executeSort("insertionSort", data2);
//        printArray(executeSort("shellSort", data2));
//        printArray(executeSort("mergeSort", data));
//        executeSort("selectionSort", data);
//        executeSort("insertionSort", data1);
//        executeSort("bubbleSort", data2);
//        executeSort("shellSort", data3);
//        executeSort("mergeSort", data4);
//        executeSort("mergeSort", data3);
//        executeSort("mergeSortBottomUp", data4);
//        executeSort("quickSort", data3);
//        executeSort("quickSortTwoWays", data1);
//        Util.executeSort("org.jinlong.study.algorithm.Sort", "mergeSortBottomUp", data2);
//        Util.executeSort("org.jinlong.study.algorithm.Sort", "heapSort", data1);
//        Util.executeSort("org.jinlong.study.algorithm.Sort", "heapSort1", data3);
//        Util.executeSort("org.jinlong.study.algorithm.BinarySearch", "search", data);

    }

}
