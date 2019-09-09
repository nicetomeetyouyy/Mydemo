package com.xjm.demo.strategy;

/**
 * 冒泡排序算法
 */
public class BubbleSort implements SortStrategy {
    public int[] sort(int[] arr) {
        int length=arr.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-1-i;j++){
                int temp;
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("冒泡排序算法");
        return arr;
    }
}
