package com.xjm.demo.factory;

import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

/**
 * 抽象工厂类，制造鞋子和鞋盒
 */
public interface ShoseFactory {
    public Shoes createShose();
    public Shobox createShobox();
}
