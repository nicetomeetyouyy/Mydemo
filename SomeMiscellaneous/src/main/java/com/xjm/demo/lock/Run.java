package com.xjm.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private int sum=100;
    public void run() throws InterruptedException {
        lock.lock();
        for(int i=0;i<100;i++){
            sum=sum+1;
            System.out.println(sum);
            if(i==50){
                condition.await();
            }
        }
        lock.unlock();
    }
    public void release(){
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
