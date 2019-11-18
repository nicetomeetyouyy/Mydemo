package com.xjm.demo.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class HillSort {
    /**
     * knuth间隔序列的希尔排序算法实现
     * @param array
     * @return
     */
    public static int[] sort(int []array){
        int lenth=array.length;
        System.out.println("原来:"+ Arrays.toString(array));
        int step=1;
        while (step<=lenth/3){
            step=step*3+1;
        }
        while (step>0){
            for(int i=step;i<lenth;i++){
                int temp=array[i];
                int j=i;
                while (j>step-1&&array[j-step]>temp){
                    array[j]=array[j-step];
                    j-=step;
                }
                array[j]=temp;
            }
            System.out.println(step+"轮:"+ Arrays.toString(array));
            step=step/3;
        }
        return array;

    }

    /**
     * 为length/2的希尔排序
     * @param array
     * @return
     */
    public static int[] sort2(int[] array){
        int lenth=array.length;
        System.out.println("原来:"+ Arrays.toString(array));
        for(int step=lenth/2;step>0;step/=2){
            for(int i=step;i<lenth;i++){
                int temp=array[i];
                int j=i;
                while (j>step-1&&array[j-step]>temp){
                    array[j]=array[j-step];
                    j-=step;
                }
                array[j]=temp;
            }
            System.out.println(step+"轮:"+ Arrays.toString(array));
        }
        return array;
    }

    public static void main(String[] args) {
//        int[] array = {4,2,8,9,5,7,6,1,10,3,15,14,12,11,34,12,22,17,89,65,23,55,653,635,46,8,86,35,76,86,35,2,54,64,9};
//        int[] a=sort(array);
//        System.out.println(Arrays.toString(a));
        int[] array = {4,2,8,9,5,7,6,1,3,10};
        int[]a=sort2(array);
        System.out.println(Arrays.toString(a));
    }

}
