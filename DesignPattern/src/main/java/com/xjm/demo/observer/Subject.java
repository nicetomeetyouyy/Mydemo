package com.xjm.demo.observer;

/**
 * 抽象观察目标
 */
public interface Subject {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyObserver();
}
