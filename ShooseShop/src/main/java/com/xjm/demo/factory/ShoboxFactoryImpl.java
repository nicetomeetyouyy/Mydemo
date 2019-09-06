package com.xjm.demo.factory;

import com.xjm.demo.shoses.Shobox;

public class ShoboxFactoryImpl implements ShoboxFactory{
    @Override
    public Shobox getShobox(String size, String corlor) {
        return new Shobox(size,corlor);
    }
}
