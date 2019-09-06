package com.xjm.demo.factory;

import com.xjm.demo.sharepart.*;

import java.util.HashMap;

/**
 * 享元模式，返回鞋子配件
 * 设置单例模式
 */
public class PartFactory {
    private HashMap<String, SolePart> soleParts=new HashMap<>();
    private HashMap<String, LacePart> laceParts=new HashMap<>();
    private HashMap<String, InsolePart> insoleParts=new HashMap<>();
    private HashMap<String, TonguePart> tongueParts=new HashMap<>();
    private static PartFactory instance ;
    public static PartFactory getInstance(){
        if(instance==null){
            instance=new PartFactory();
        }
        return instance;
    }
    public Part getSolePart(String color){
        SolePart part=soleParts.get(color);
        if(part==null){
            part=new SolePart();
            part.setCorlor(color);
            part.setPart();
            soleParts.put("color",part);
        }
        return part;
    }
    public Part getLacePart(String color){
        LacePart part=laceParts.get(color);
        if(part==null){
            part=new LacePart();
            part.setCorlor(color);
            part.setPart();
            laceParts.put("color",part);
        }
        return part;
    }
    public Part getInsolePart(String color){
        InsolePart part=insoleParts.get(color);
        if(part==null){
            part=new InsolePart();
            part.setCorlor(color);
            part.setPart();
            insoleParts.put("color",part);
        }
        return part;
    }
    public Part getTonguePart(String color){
        TonguePart part=tongueParts.get(color);
        if(part==null){
            part=new TonguePart();
            part.setCorlor(color);
            part.setPart();
            tongueParts.put("color",part);
        }
        return part;
    }
}
