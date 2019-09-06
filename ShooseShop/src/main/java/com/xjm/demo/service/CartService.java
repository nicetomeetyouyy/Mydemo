package com.xjm.demo.service;

import java.util.List;

public interface CartService {
    public void addShoes(Object object);
    public void deletShoes(Object object);
    public List<Object> showCart();
}
