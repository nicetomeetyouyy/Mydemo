package com.xjm.demo.builder;

public class Manager {
    private Builder builder;

    public void serBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 调用builer组装产品
     * @return
     */
    public LivingRoom getLivingRoom(){
        builder.builderTV();
        builder.builderWall();
        return builder.getResult();
    }
}
