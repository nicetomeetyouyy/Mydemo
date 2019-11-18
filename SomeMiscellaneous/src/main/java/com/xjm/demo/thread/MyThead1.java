package com.xjm.demo.thread;

public class MyThead1 extends Thread {
    @Override
    public void run() {

        for(int i=0;i<50000;i++){
            System.out.println(i);
        }
    }
}
