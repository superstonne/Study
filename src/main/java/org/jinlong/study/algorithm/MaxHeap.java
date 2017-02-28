package org.jinlong.study.algorithm;

import java.util.Random;

/**
 * Created by nick on 21/02/2017.
 */
public class MaxHeap {
    private int count;
    private int capacity;
    public int[] heap;

    public MaxHeap(int size) {
        heap = new int[size + 1];
        capacity = size;
        count = 0;
    }

    public MaxHeap( int[] arr) {
        heap = new int[arr.length + 1];
        capacity = arr.length;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            heap[i + 1] = arr[i];
            count++;
        }
        for (int i = arr.length / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public void insertHeap(int item) {
        if (count + 1 > capacity) {
            System.err.println("Failed because of out of capacity.");
            return;
        }
        heap[count + 1] = item;
        shiftUp(count + 1);
        count++;
    }
    public int offer() {
        if (count < 1) {
            return Integer.MAX_VALUE;
        }
        int result = heap[1];
        Util.swapArrayByIndex(heap, 1, count);
        count--;
        shiftDown(1);
        return result;
    }
    private void shiftUp(int index) {
        int parent = index / 2;
        while (parent > 0 && (heap[index] > heap[parent])) {
            Util.swapArrayByIndex(heap, index, parent);
            index = parent;
            parent = parent / 2;
        }
    }
    private void shiftDown(int index) {
        while (index * 2 <= count) {
            int left = index * 2;
            if (left + 1 <= count && heap[left + 1] >= heap[left]) {
                left += 1;
            }
            if (heap[index] >= heap[left]) {
                break;
            }
            Util.swapArrayByIndex(heap, left, index);
            index = left;
        }
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(20000);
        System.out.println(heap.size());
        Random number = new Random(47);
        for (int i = 0; i < 10000; i++) {
            heap.insertHeap(number.nextInt(10000));
        }
        while (heap.size() > 0) {
            System.out.print(heap.offer());
            System.out.print(" ");
        }
    }
}
