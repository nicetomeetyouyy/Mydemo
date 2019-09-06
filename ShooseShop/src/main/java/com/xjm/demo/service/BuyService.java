package com.xjm.demo.service;

import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

public interface BuyService {
    public void showShoes();
    public Shoes diyShoes(String [] color);
    public Shobox diyShobox(String logo,String size, String color);
}
