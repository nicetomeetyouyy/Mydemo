package com.xjm.demo.sington;

public class Myobject {
    private static Myobject myobject;

    public static Myobject getInstance(){
        if(myobject==null){
            synchronized (Myobject.class){
                if(myobject==null){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myobject=new Myobject();
                }
            }
        }
        return myobject;
    }
}
