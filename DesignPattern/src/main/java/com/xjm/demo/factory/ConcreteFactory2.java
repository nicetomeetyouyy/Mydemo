package com.xjm.demo.factory;
//具体实现工厂2
public class ConcreteFactory2 implements Factory {
    public Product newProduct() {
        System.out.println("工厂2生成产品2");
        return new ConcreteProduct2();
    }
}
