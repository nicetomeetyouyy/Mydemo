package com.xjm.demo.factory;

import com.xjm.demo.shoses.Shobox;

/**
 * 工厂方法创建鞋盒
 */
public interface ShoboxFactory {
    public Shobox getShobox(String size,String corlor);
}
