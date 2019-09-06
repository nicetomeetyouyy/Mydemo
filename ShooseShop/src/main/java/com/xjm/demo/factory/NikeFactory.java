package com.xjm.demo.factory;

import com.xjm.demo.sharepart.InsolePart;
import com.xjm.demo.sharepart.LacePart;
import com.xjm.demo.sharepart.SolePart;
import com.xjm.demo.sharepart.TonguePart;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

/**
 * 实现抽象工厂
 * 使用代理模式实现鞋盒的生产创建
 */
public class NikeFactory implements ShoseFactory{
     private PartFactory partFactory=PartFactory.getInstance();//单例工厂
     private ShoboxFactory shoboxFactory=new ShoboxFactoryImpl();//代理鞋盒工厂
    @Override
    public Shoes createShose() {
        Shoes shoes=new Shoes();
        shoes.setColor("白色");
        shoes.setSole((SolePart) partFactory.getSolePart("黄色"));
        shoes.setLace((LacePart) partFactory.getLacePart("绿色"));
        shoes.setInsole((InsolePart) partFactory.getInsolePart("红色"));
        shoes.setTongue((TonguePart) partFactory.getTonguePart("黑色"));
        return shoes;
    }

    @Override
    public Shobox createShobox() {
        Shobox shobox=shoboxFactory.getShobox("40寸","黑色");
        shobox.setLogo("nike");
        return shobox;
    }
}
