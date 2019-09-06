package com.xjm.demo.abstractfactory;

public interface LifeFactory {
    public Object newAnimal(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
    public Object newPlant(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
