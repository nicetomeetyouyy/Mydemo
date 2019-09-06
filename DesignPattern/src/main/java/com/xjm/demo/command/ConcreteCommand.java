package com.xjm.demo.command;
//具体命令
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void excute() {
      System.out.println("我要把命令发出去");
      receiver.action();
    }
}
