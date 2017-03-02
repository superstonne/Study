package org.jinlong.study.algorithm;

/**
 * Created by nick on 02/03/2017.
 */

/**
 * 二分查找算法实现的俩种方式
 */
public class BinarySearch {

    /**
     * 使用非递归方法实现二分查找算法，时间复杂度为Log N
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //防止数值过大
        int middle = left + (right - left) / 2;
        while (left <= right) {
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }

    /**
     * 使用递归方法实现二分查找算法
     * @param arr
     * @param target
     * @return
     */
    public static int searchByRecursive(int[] arr, int target) {
        int result = _search(arr, 0, arr.length - 1, target);
        return result;
    }
    private static int _search(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] > target) {
            right = middle - 1;
        } else {
            left = middle + 1;
        }
        return _search(arr, left, right, target);
    }

    public static void main(String[] args) {
        BinarySearch binary = new BinarySearch();
        int[] data = Util.generateOrderedArray(10000, 100000);
        int result1 = binary.search(data, 123);
        System.out.println("Result is: " + result1);
        int result2 = binary.searchByRecursive(data, 789);
        System.out.println("Result is: " + result2);
    }


}
