package com.xjm.demo.vistor;

/**
 * 抽象访问者
 * 两个访问不同元素的访问
 */
public interface Visitor {
    public void visit(ConcreteElement1 concreteElement1);
    public void visit(ConcreteElement2 concreteElement2);
}
