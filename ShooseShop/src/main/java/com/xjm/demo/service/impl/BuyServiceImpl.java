package com.xjm.demo.service.impl;

import com.xjm.demo.diyshoes.Builder;
import com.xjm.demo.factory.NikeFactory;
import com.xjm.demo.factory.PartFactory;
import com.xjm.demo.factory.ShoboxFactory;
import com.xjm.demo.factory.ShoboxFactoryImpl;
import com.xjm.demo.service.BuyService;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

public class BuyServiceImpl implements BuyService {
    private PartFactory partFactory=PartFactory.getInstance();//单例工厂
    private Builder builder;
    private ShoboxFactory shoboxFactory=new ShoboxFactoryImpl();
    public  BuyServiceImpl(Builder builder) {
        this.builder = builder;
    }

    @Override
    public void showShoes() {
        NikeFactory nikeFactory =new NikeFactory();
        Shoes shoes= nikeFactory.createShose();
        Shobox shobox=nikeFactory.createShobox();
        System.out.println("鞋子款式:"+shoes.toString());
        System.out.println("鞋盒款式:"+shobox.toString());
    }

    @Override
    public Shoes diyShoes(String [] color) {
        int i=0;
        builder.buildColor(color[i++]);
        builder.buildeSole(color[i++]);
        builder.buildeTongue(color[i++]);
        builder.buildeLace(color[i++]);
        builder.buildeInsole(color[i++]);
        return builder.getShoes();
    }

    @Override
    public Shobox diyShobox(String logo,String size, String color) {
        Shobox shobox=shoboxFactory.getShobox(size,color);
        shobox.setLogo(logo);
        return shobox;

    }
}
