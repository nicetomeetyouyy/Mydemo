package com.xjm.demo.proxy;

public class Proxy {
    private RealSubject realSubject;

    /**
     * 调用真实主题方法
     */
    public void Requset(){
        if(realSubject==null){
            realSubject=new RealSubject();
        }
        realSubject.Request();
    }
}
