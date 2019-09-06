package com.xjm.demo.service.impl;

import com.xjm.demo.Iterator.Aggregate;
import com.xjm.demo.Iterator.Cart;
import com.xjm.demo.Iterator.Iterator;
import com.xjm.demo.service.CartService;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车操作服务
 */
public class CartServiceImpl implements CartService {
    private Aggregate aggregate =new Cart();

    @Override
    public void addShoes(Object object) {
        aggregate.add(object);
    }

    @Override
    public void deletShoes(Object object) {
        aggregate.remove(object);
    }

    @Override
    public List<Object> showCart() {
        Iterator iterator=aggregate.getIterator();
        List<Object> list=new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
