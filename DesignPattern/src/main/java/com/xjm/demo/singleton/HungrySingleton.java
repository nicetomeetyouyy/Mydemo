package com.xjm.demo.singleton;

public class HungrySingleton {
    /**
     * 创建实例对象
     */
    private static HungrySingleton hungrySingleton=new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
