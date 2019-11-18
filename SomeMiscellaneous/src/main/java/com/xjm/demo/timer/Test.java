package com.xjm.demo.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Test {
    public static void main(String[] args) throws Exception {
        MyTimer myTimer=new MyTimer();
        Timer timer=new Timer();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse("2019-09-30 09:35:30");
        System.out.println(new Date());
//        timer.schedule(myTimer,date);
        timer.scheduleAtFixedRate(myTimer,date,2000);
//        timer.schedule(myTimer,date,2000);
    }
}
