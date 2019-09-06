package com.xjm.demo.builder;

public class ConcreteBuilder2 extends Builder {
    @Override
    public void builderTV() {
        livingRoom.setTV("20寸");
    }

    @Override
    public void builderWall() {
       livingRoom.setWall("绿色");
    }
}
