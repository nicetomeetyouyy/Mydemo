package com.xjm.demo.vistor;

public class ConcreteVisitor1 implements Visitor{
    public void visit(ConcreteElement1 concreteElement1) {
        concreteElement1.setName("访问者1设置Element1");
        System.out.println(concreteElement1.getName());
    }

    public void visit(ConcreteElement2 concreteElement2) {
      concreteElement2.setName("访问者1设置Element2");
        System.out.println(concreteElement2.getName());
    }
}
