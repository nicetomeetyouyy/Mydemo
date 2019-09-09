package com.xjm.demo.iterator;

import java.util.List;

/**
 * 迭代器实现
 */
public class ConcreteIterator implements Iterator {
    private List<Object> list=null;
    private int index=-1;
    public ConcreteIterator(List<Object> list){
        this.list=list;
    }

    /**
     * 获取下一个对象
     * @return
     */
    public Object next() {
        Object obj=null;
        if(this.hasNext())
        {
            obj=list.get(++index);
        }
        return obj;
    }

    /**
     * 判断是否有对象
     * @return
     */
    public boolean hasNext() {
        if(index<list.size()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
