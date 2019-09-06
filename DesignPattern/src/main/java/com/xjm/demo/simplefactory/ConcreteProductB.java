package com.xjm.demo.simplefactory;
//具体产品
public class ConcreteProductB extends Product {
    @Override
    public void used() {
        System.out.println("B在使用");
    }
}
