package com.xjm.demo.simplefactory;
//具体产品
public class ConcreteProductA extends Product{

@Override
    public void used() {
       System.out.println("A在使用着");
    }
}
