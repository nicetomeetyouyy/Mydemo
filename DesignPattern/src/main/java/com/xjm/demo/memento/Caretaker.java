package com.xjm.demo.memento;

/**
 * 管理者
 */
public class Caretaker {
    private Memento memento;

    /**
     * 保存备忘录
     * @param m
     */
    public void setMemento(Memento m)
    {
        memento=m;
    }

    /**
     * 获取备忘录
     * @return
     */
    public Memento getMemento()
    {
        return memento;
    }
}
