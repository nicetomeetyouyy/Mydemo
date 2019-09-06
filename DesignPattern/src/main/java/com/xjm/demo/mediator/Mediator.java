package com.xjm.demo.mediator;

/**
 * 抽象中介，注册同事和转发消息
 */
public interface Mediator {
    public void register(Collcague collcague);
    public void relay(String message,Collcague collcague);
}
