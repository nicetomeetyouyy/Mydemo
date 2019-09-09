package com.xjm.demo.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合对象
 */
public class ConcreteAggreate implements Aggregate {
    private List<Object> list=new ArrayList<Object>();

    /**
     * 添加对象
     * @param obj
     */
    public void add(Object obj) {
        list.add(obj);
    }

    /**
     * 删除对象
     * @param obj
     */
    public void remove(Object obj) {
        list.remove(obj);
    }

    /**
     * 获取迭代器
     * @return
     */
    public Iterator getIterator() {
        return(new ConcreteIterator(list));
    }

}
