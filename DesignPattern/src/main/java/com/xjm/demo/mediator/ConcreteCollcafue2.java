package com.xjm.demo.mediator;

public class ConcreteCollcafue2 extends Collcague {

    @Override
    public void receive(String message) {
        System.out.println("2收到消息:"+message);
    }

    @Override
    public void send(String message) {
        mediator.relay(message,this);
    }
}