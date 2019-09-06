package com.xjm.demo.singleton;

public class SynLazySingleton {
    /**
     * 利用静态变量来记录Singleton的唯一实例
     */
    private static SynLazySingleton synLazySingleton=null;
    /**
     * 构造方法私有化，避免被创建实例
     */
    private SynLazySingleton(){}
    /*
      直接加synronized关键字
     public static synchronized LazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }
     */

    /**
     *  用“双重检查加锁”，在getInstance()中减少使用同步
     * @return SynLazySingleton
     */
    public static SynLazySingleton getInstance(){
        if(synLazySingleton==null){
            synchronized (SynLazySingleton.class){
                if (synLazySingleton==null){
                    synLazySingleton= new SynLazySingleton();
                }
            }
        }
        return synLazySingleton;
    }


}
