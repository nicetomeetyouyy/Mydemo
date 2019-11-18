package com.xjm.demo.threadlocal;

public class T1 extends Thread {
    @Override
    public  void run() {
        super.run();
        for(int i=0;i<100;i++){
            Tool.t.set("t1   "+i);
            System.out.println("T1:"+Tool.t.get());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
