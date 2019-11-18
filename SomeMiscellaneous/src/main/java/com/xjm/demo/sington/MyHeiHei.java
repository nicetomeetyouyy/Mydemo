package com.xjm.demo.sington;

/**
 * 枚举创建
 */
public enum MyHeiHei {
    Myheihei;
    private EnumTest enumTest;
    private MyHeiHei(){
        enumTest=new EnumTest();
    }
    public EnumTest getEnumTest(){
        return enumTest;
    }
}
