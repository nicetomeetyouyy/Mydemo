package com.xjm.demo.decorator;
//测试
public class decoratorClient {
    public static void main(String[] args) {
        Component p=new ConcreteComponent();
        p.Operation();
        System.out.println("______________");
        Component p1=new Decorator(p);
        p.Operation();
        System.out.println("______________");
        Component p2=new ConcreteDecorator(p);
        p2.Operation();
    }
}
