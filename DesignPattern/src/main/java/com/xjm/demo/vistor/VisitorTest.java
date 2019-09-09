package com.xjm.demo.vistor;

/**
 * 测试访问者模式
 */
public class VisitorTest {
    public static void main(String[] args) {
        ObjectStructure objectStructure=new ObjectStructure();
        objectStructure.add(new ConcreteElement1());
        objectStructure.add(new ConcreteElement2());
        Visitor visitor=new ConcreteVisitor1();
        objectStructure.accept(visitor);
        System.out.println("------------");
        visitor=new ConcreteVIsitor2();
        objectStructure.accept(visitor);
    }
}
