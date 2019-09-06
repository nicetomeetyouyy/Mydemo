package com.xjm.demo.builder;

public abstract class Builder {
     protected LivingRoom livingRoom=new LivingRoom();

    /**
     * 构建TV
     */
    public abstract void builderTV();

    /**
     * 构建墙壁
     */
     public abstract void builderWall();
     public LivingRoom getResult(){
         return livingRoom;
     }
}
