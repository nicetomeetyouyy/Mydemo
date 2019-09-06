package com.xjm.demo.diyshoes;
/**
 * 建造者模式
 * 抽象建造者
 * 代理模式使用配件工厂
 * 桥接者模式使用鞋盒工厂使用
 */

import com.xjm.demo.factory.PartFactory;
import com.xjm.demo.factory.ShoboxFactory;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

public abstract class Builder {
    protected PartFactory partFactory=PartFactory.getInstance();
    protected ShoboxFactory shoboxFactory;
    protected Shoes shoes;
    protected Shobox shobox;
    public abstract void buildColor(String color);
    public abstract void buildeSole(String color);
    public abstract void buildeInsole(String color);
    public abstract void buildeLace(String color);
    public abstract void buildeTongue(String color);
    public abstract void buildeShobox(String logo,String size,String corlor);
    public Shoes getShoes(){
        return this.shoes;
    }
    public Shobox getShobox(){
        return this.shobox;
    }
}
