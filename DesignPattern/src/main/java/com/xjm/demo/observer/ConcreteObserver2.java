package com.xjm.demo.observer;

public class ConcreteObserver2 implements Observer {
    public void update(String message) {
        System.out.println("观察者2更新消息:"+message);
    }
}