package com.xjm.demo.strategy;

/**
 * 策略的选择环境类
 */
public class ContenxtSort {
    private SortStrategy sortStrategy;

    public SortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    /**
     * 对算法排序并输出
     * @param arr
     */
    public void sort(int []arr){
        int []a=sortStrategy.sort(arr);
        for (int b:a
             ) {
            System.out.print(b);
        }
        System.out.println(" ");
    }
}
