package com.xjm.demo.lock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Run run=new Run();
        Th1 th1=new Th1(run);
        Th2 th2=new Th2(run);
        th1.start();
        th2.start();
        Thread.sleep(1000);
        run.release();
        Thread.sleep(1000);
        run.release();
    }
}
