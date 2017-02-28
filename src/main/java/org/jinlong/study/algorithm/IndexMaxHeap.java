package org.jinlong.study.algorithm;

import java.util.Random;

/**
 * Created by nick on 21/02/2017.
 */
public class IndexMaxHeap {
    private int count;
    private int capacity;
    private int[] data;
    private int[] index;

    public IndexMaxHeap(int size) {
        data = new int[size + 1];
        index = new int[size + 1];
        capacity = size;
        count = 0;
    }

    public IndexMaxHeap(int[] arr) {
        data = new int[arr.length + 1];
        capacity = arr.length;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
            index[i] = i;
            count++;
        }
        for (int i = arr.length / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public void insertHeap(int i, int item) {
        if (count + 1 > capacity) {
            System.err.println("Failed because of out of capacity.");
            return;
        }
        index[i + 1] = i;
        data[count + 1] = item;
        shiftUp(count + 1);
        count++;
    }
    public int offer() {
        if (count < 1) {
            return Integer.MAX_VALUE;
        }
        int result = data[index[1]];
        Util.swapArrayByIndex(index, 1, count);
        count--;
        shiftDown(1);
        return result;
    }
    public int offerMaxIndex() {
        if (count < 1) {
            return Integer.MAX_VALUE;
        }
        int result = index[1];
        Util.swapArrayByIndex(index, 1, count);
        count--;
        shiftDown(1);
        return result;
    }
    public int getDataByIndex(int k) {
        return data[k];
    }
    private void shiftUp(int k) {
        int parent = k / 2;
        while (parent > 0 && (data[index[k]] > data[index[parent]])) {
            Util.swapArrayByIndex(index, k, parent);
            k = parent;
            parent = parent / 2;
        }
    }
    private void shiftDown(int k) {
        while (k * 2 <= count) {
            int left = k * 2;
            if (left + 1 <= count && data[index[left + 1]] >= data[index[left]]) {
                left += 1;
            }
            if (data[index[k]] >= data[index[left]]) {
                break;
            }
            Util.swapArrayByIndex(index, left, k);
            k = left;
        }
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        IndexMaxHeap heap = new IndexMaxHeap(10);
        Random number = new Random(47);
        for (int i = 0; i < 10; i++) {
            int item = number.nextInt(10);
            heap.insertHeap(i, item);
            System.out.println("Put " + item + " into " + i);
        }
        while (heap.size() > 0) {
            System.out.print(heap.getDataByIndex(heap.offerMaxIndex()));
            System.out.print(" ");
        }
    }
}
