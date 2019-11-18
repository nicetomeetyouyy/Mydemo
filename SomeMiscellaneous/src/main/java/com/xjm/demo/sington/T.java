package com.xjm.demo.sington;

public class T extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(MyHeiHei.Myheihei.getEnumTest().hashCode());
    }
}
