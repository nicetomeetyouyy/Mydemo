package com.xjm.demo.singleton;

public class LazySingleton {
    /**
     * 利用静态变量来记录Singleton的唯一实例
     */
    private static LazySingleton lazySingleton=null;

    /**
     * 构造方法私有化，避免被创建实例
     */
    private LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }



}
