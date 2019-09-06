package com.xjm.demo.mediator;

public class ConcreteCollcague1 extends Collcague {

    @Override
    public void receive(String message) {
        System.out.println("1收到消息:"+message);
    }

    @Override
    public void send(String message) {
        mediator.relay(message,this);
    }
}
