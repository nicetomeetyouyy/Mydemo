package com.xjm.demo.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * 抽象目标实现
 */
public class SubjectImpl implements Subject {
    private List<Observer>list=new ArrayList<Observer>();

    /**
     * 添加观察对象
     * @param observer
     */
    public void add(Observer observer) {
        if(!list.contains(observer)){
            list.add(observer);
        }
    }

    /**
     *删除观察对象
     * @param observer
     */
    public void remove(Observer observer) {
        list.remove(observer);
    }

    /**
     * 通知观察对象
     */
    public void notifyObserver() {
        for (Observer o:list
             ) {
            o.update("我更新了啊" );
        }
    }
}
