package com.xjm.demo.timer;

import java.util.Date;
import java.util.TimerTask;

public class MyTimer extends TimerTask {
    @Override
    public void run() {

        System.out.println("开始时间："+new Date());
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("结束时间："+new Date());
    }
}
