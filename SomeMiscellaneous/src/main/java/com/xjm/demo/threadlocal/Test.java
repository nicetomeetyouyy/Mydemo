package com.xjm.demo.threadlocal;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        T1 t=new T1();
        T2 t2=new T2();
        t.start();
        t2.start();
        for(int i=0;i<100;i++){
            Tool.t.set("main"+i);
            System.out.println("main:"+Tool.t.get());
            Thread.sleep(200);
        }
    }
}
