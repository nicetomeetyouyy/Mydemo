package com.xjm.demo.thread;

public class MyRunable implements Runnable {

    public MyRunable() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
//        for(int i=0;i<50;i++){
//            System.out.println(i+"Runnable");
//        }
        System.out.println(Thread.currentThread().getName());
    }
}
