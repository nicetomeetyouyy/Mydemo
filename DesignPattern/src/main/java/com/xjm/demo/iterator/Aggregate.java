package com.xjm.demo.iterator;

/**
 * 抽象聚合对象
 */
public interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}
