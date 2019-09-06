package com.xjm.demo.command;
//模拟客户端
public class CommandClient {
    public static void main(String[] args) {
        //设置命令接受者对象
        Receiver receiver=new Receiver();
        //确定命令接收对象
        Command command=new ConcreteCommand(receiver);
        //建立调用者
        Invoker invoker=new Invoker(command);
        invoker.call();

    }
}
