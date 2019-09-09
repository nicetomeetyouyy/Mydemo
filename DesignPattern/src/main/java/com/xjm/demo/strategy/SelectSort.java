package com.xjm.demo.strategy;

/**
 * 选择排序
 */
public class SelectSort implements SortStrategy {
    public int[] sort(int[] arr) {
        int length=arr.length;
        for(int i=0;i<length-1;i++){
            int min=i;
            for(int j=i+1;j<length-1;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;}
        }
        System.out.println("选择排序");
        return arr;
    }
}
