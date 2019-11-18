package com.xjm.demo.thread;

public class MyThead2 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(i+"我是线程2");
        }
    }
}
