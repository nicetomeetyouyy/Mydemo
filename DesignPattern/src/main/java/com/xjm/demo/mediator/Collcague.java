package com.xjm.demo.mediator;

/**
 * 抽象同事，注册中介
 * 具有接受消息和发送消息功能
 */
public abstract class Collcague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void receive(String message);
    public abstract void send(String message);
}
