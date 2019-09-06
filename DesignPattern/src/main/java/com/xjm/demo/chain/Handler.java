package com.xjm.demo.chain;
//抽象处理者角色
public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(int request);
}
