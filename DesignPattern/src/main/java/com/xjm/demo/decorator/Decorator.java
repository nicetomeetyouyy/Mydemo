package com.xjm.demo.decorator;
//抽象装饰角色，还是调用Component类的方法
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void Operation() {
        component.Operation();
    }
}
