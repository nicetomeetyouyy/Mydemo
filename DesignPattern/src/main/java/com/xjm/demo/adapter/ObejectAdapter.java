package com.xjm.demo.adapter;
//对象适配器类
public class ObejectAdapter implements Target {
   private Adaptee adaptee;

    public ObejectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.adapteeRequest();
    }
}
