package com.xjm.demo.observer;

public class ConcreteObserver1 implements Observer {
    public void update(String message) {
        System.out.println("观察者1更新消息:"+message);
    }
}
