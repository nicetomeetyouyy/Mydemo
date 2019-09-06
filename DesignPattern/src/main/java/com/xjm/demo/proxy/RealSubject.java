package com.xjm.demo.proxy;

public class RealSubject implements Subject {
    /**
     * 实现Subject的抽象方法
     */
    public void Request() {
        System.out.println("真实主题方法来了");
    }
}
