package com.xjm.demo.decorator;
//具体装饰的角色，通过继承抽象装饰类添加新功能
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        super.Operation();
        addOperation();

    }
    public void addOperation(){
        System.out.println("huhu我给加了点功能");
    }
}
