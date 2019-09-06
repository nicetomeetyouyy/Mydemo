package com.xjm.demo.decorator;
//抽象构件的实现方法
public class ConcreteComponent implements Component {
    public void Operation() {
        System.out.println("我是ConcreteComponent实现了operation方法");
    }
}
