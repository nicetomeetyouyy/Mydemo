package com.xjm.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatitleThead extends Thread {
//    volatile public static  int count;
    private static AtomicInteger count=new AtomicInteger(0);
  /*  private static void add(){
        for (int i=0;i<100;i++){
//            count=count+1;
            System.out.println(count);
        }
//        System.out.println("count="+count);
    }*/
    @Override
    public  void run() {
        super.run();
        for (int i=0;i<100;i++){
            System.out.println("count="+count.incrementAndGet());
        }
        count.addAndGet(1);
    }
}
