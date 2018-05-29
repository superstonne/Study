package org.jinlong.study.algorithm;

/**
 * Using quick sort to find the Kth big number in an array.
 */
public class QuickSort {

    public static final int KTH = 10;

    public static int KTH_NUM = -1;

    public static void main(String[] args) {
        int[] arr = new int[] {10, 8, 100, 2, 33, 16, 99, 13, 2, 4, 2, 3, 88};
        sort(arr, 0, arr.length);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int flagIndex = findFlagIndex(arr, left, right);
        if (flagIndex == KTH - 1) {
            System.out.println(arr[flagIndex]);
        }
        sort(arr, left, flagIndex);
        sort(arr, flagIndex + 1, right);
    }

    public static int findFlagIndex(int[] arr, int left, int right) {
        int flag = arr[left];
        int flagIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < flag) {
                int temp = arr[i];
                arr[i] = arr[flagIndex + 1];
                arr[flagIndex + 1] = temp;
                flagIndex++;
            }
        }
        arr[left] = arr[flagIndex];
        arr[flagIndex] = flag;
        return flagIndex;
    }
}
