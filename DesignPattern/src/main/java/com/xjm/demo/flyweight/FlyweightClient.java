package com.xjm.demo.flyweight;

public class FlyweightClient {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory=new FlyweightFactory();
        FlyWeight flyWeight1=flyweightFactory.getFlyWeight("红");
        FlyWeight flyWeight2=flyweightFactory.getFlyWeight("红");
        UnshareFlyWeight unshareFlyWeight=new UnshareFlyWeight("轮船");
        flyWeight1.draw(unshareFlyWeight);
        System.out.println(flyWeight1==flyWeight2);
         flyWeight2=flyweightFactory.getFlyWeight("黄");
         flyWeight2.draw(unshareFlyWeight);
    }
}
