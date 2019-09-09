package com.xjm.demo.vistor;

public class ConcreteElement2 implements Element {
    private String name;
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
