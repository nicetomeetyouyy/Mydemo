package com.xjm.demo.thread;

public class Addsome {
    private int num=1000 ;
     void add(int n) throws InterruptedException {
        synchronized (this){num-=n;}
        System.out.println(num);
        Thread.sleep(20);
    }
}
