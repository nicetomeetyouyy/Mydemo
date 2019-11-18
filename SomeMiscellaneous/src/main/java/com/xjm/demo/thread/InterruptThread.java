package com.xjm.demo.thread;

public class InterruptThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0;i<500000;i++){
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThread i=new InterruptThread();
        i.start();
        sleep(10000);

        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println("end");
    }
}
