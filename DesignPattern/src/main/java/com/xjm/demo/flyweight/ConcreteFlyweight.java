package com.xjm.demo.flyweight;
//共享的颜色
public class ConcreteFlyweight implements FlyWeight {
    private String color;

    public ConcreteFlyweight(String color ) {
        this.color = color;
        System.out.println(color+"色被创建了");
    }

    public void draw(UnshareFlyWeight unshareFlyWeight) {
    System.out.println(color+unshareFlyWeight.getShare());
    }
}
