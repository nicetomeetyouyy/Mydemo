package com.xjm.demo.strategy;

/**
 * 测试客户端
 */
public class StrategyClient {
    public static void main(String[] args) {
        ContenxtSort contenxtSort=new ContenxtSort();
        int []a ={3,6,7,2,5,1,8};
        contenxtSort.setSortStrategy(new BubbleSort());
        contenxtSort.sort(a);
        int []b ={3,6,7,2,5,1,8};
        contenxtSort.setSortStrategy(new InsertionSort());
        contenxtSort.sort(b);
        int []c ={3,6,7,2,5,1,8};
        contenxtSort.setSortStrategy(new SelectSort());
        contenxtSort.sort(c);

    }
}
