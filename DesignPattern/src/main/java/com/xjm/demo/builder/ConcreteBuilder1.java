package com.xjm.demo.builder;

public class ConcreteBuilder1 extends Builder {
    @Override
    public void builderTV() {
        livingRoom.setTV("45寸");
    }

    @Override
    public void builderWall() {
         livingRoom.setWall("红色");
    }
}
