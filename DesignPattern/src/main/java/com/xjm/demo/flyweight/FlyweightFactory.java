package com.xjm.demo.flyweight;

import java.util.HashMap;
//存在直接返回，不存在创建
public class FlyweightFactory {
    private HashMap<String,FlyWeight>flyweights =new HashMap<String, FlyWeight>();
    public FlyWeight getFlyWeight(String key){
        FlyWeight flyWeight=flyweights.get(key);
        if(flyWeight==null){
            flyWeight=new ConcreteFlyweight(key);
            flyweights.put(key,flyWeight);
        }
        return flyWeight;
    }
}
