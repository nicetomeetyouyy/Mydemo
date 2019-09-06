package com.xjm.demo.composite;
//树叶构件
public class Leaf implements Tree {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是树叶:"+name);
    }
}
