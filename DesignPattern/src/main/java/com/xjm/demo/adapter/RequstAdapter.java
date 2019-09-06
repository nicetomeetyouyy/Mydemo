package com.xjm.demo.adapter;
//请求适配器
public class RequstAdapter extends Adaptee implements Target {
    public void request() {
        adapteeRequest();
    }
}
