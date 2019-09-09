package com.xjm.demo.strategy;

/**
 * 插入排序
 */
public class InsertionSort implements SortStrategy {
    public int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] >temp) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("插入排序");
        return arr;
    }
}
