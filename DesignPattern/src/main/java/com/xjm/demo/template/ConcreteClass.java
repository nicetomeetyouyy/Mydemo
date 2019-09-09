package com.xjm.demo.template;

/**
 * 具体实现模板
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("子类实现抽象方法1");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("子类实现抽象方法2");
    }
}
