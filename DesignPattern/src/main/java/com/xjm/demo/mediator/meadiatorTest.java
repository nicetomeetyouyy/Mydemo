package com.xjm.demo.mediator;

public class meadiatorTest {
    public static void main(String[] args) {
        Mediator mediator=new ConcreteMediator();
        Collcague collcague1=new ConcreteCollcague1();
        Collcague collcague2=new ConcreteCollcafue2();
        collcague1.setMediator(mediator);
        collcague2.setMediator(mediator);
        mediator.register(collcague1);
        mediator.register(collcague2);
        collcague1.send("我是1号");
        collcague2.send("我是2号");
    }

}
