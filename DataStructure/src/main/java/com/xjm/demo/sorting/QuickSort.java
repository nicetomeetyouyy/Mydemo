package com.xjm.demo.sorting;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void sort(int []array){
  quickSort(array,0,array.length-1);
    }

    /**
     * 递归分数组
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort(int[]array,int start,int end ){
        if(start>=end){
            return ;
        }else {
            int index=getIndex(array,start,end);
            quickSort(array,start,index-1);
            quickSort(array,index+1,end);
        }
    }

    /**
     * 划分左右数组并且返回标准值索引
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int getIndex(int[]array,int left,int right){
        int index=left;
        int num=array[index];
        while (left<right){
            while (left<right&&array[right]>=num){
                right--;
            }
            while (left<right&&array[left]<=num){
                left++;
            }
            int temp=array[right];
            array[right]=array[left];
            array[left]=temp;
        }
        array[index]=array[left];
        array[left]=num;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {9,9,8,7,6,5,4,3,2,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
