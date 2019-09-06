package com.xjm.demo.factory;
//具体实现工厂1
public class ConcreteFactory1 implements Factory {
    public Product newProduct() {
        System.out.println("工厂1生成产品1");
        return new ConcreteProduct1();
    }
}
