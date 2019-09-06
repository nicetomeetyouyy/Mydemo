package com.xjm.demo.bridge;
//抽象化角色
public abstract class Shape {
    protected Color color;
    public Shape(Color color){
     this.color=color;
    }

    /**
     * 画图
     */
    public abstract void draw();
}
