package com.xjm.demo.thread;

import java.util.ArrayList;

public class DeadLockTest implements Runnable {

    private Object object1=new Object();
    private Object object2=new Object();
    private int num;

    public DeadLockTest(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public DeadLockTest() {
    }

    @Override
    public void run() {
    if(num==1){

        synchronized (object1){
            System.out.println("我拿到了锁1");
            for (int i=0;i<10000;i++){
                System.out.println(i);

            }
            synchronized (object2){
                System.out.println("我进入锁2");
            }
        }
    }else {
        synchronized (object2){
            System.out.println("我在用锁2");
            for (int i=0;i<10000;i++){
                System.out.println(i);

            }
            synchronized (object1){
                System.out.println("我进入锁1了");
            }
        }
    }
    }
}
