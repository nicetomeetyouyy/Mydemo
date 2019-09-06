package com.xjm.demo.facade;

import com.xjm.demo.deractor.BuyServiceWraper;
import com.xjm.demo.service.CartService;
import com.xjm.demo.service.impl.CartServiceImpl;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

import java.util.List;

/**
 * 外观模式
 * 将各个子系统封装在一个类供客户端使用
 */
public class Facade {
    private BuyServiceWraper buyServiceWraper=new BuyServiceWraper();
    private CartService cart=new CartServiceImpl();
    public void showShoes(){
        buyServiceWraper.showShoes();
    }
    public void addToCart(Object object){
        cart.addShoes(object);
    }
    public void deleteCart(){
        List<Object>list= cart.showCart();
        for(int i=0;i<list.size();i++){
            Object o=list.get(i);
            cart.deletShoes(o);
        }

    }
    public void showCart(){
       List<Object>list= cart.showCart();
       System.out.println(list.size());
        for (Object o:list
             ) {
            System.out.println(o.toString());
        }
    }
    public Shoes diyShoes(){
        Shoes shoes=buyServiceWraper.diyShoes();
        System.out.println(shoes.toString());
        addToCart(shoes);
        return shoes;
    }
    public Shobox diyShobox(){
        Shobox shobox=buyServiceWraper.diyShobox();
         System.out.println(shobox.toString());
        addToCart(shobox);
        return shobox;
    }
}
