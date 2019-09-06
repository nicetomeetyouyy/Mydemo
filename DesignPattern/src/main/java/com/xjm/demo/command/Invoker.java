package com.xjm.demo.command;
//调用者
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void call(){
        command.excute();
    }
}
