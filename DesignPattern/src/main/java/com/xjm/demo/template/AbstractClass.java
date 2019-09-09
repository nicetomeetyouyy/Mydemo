package com.xjm.demo.template;

/**
 * 抽象模板类
 */
public abstract class AbstractClass {
    public void TemplateMethod(){
        specificMethod();
        abstractMethod2();
        abstractMethod1();

    }
    public void specificMethod(){
        System.out.println("抽象父类的方法被调用");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
