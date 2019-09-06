package com.xjm.demo.simplefactory;
//制造产品的工厂
public class Factory {
    public Product creteProduct(String arg){
        if("A".equals(arg)){
            return new ConcreteProductA();
        }else if ("B".equals(arg)){
            return new ConcreteProductB();
        }else {
            return null;
        }
    }
}
