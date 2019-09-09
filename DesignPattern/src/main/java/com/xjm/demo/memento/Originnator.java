package com.xjm.demo.memento;

/**
 * 发起人
 */
public class Originnator {
    private String state;

    public String getState() {
        return state;
    }

    /**
     * 设置状态
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建备忘录
     * @return Memento
     */
    public Memento createMemento()
    {
        return new Memento(state);
    }

    /**
     * 恢复上个状态
     * @param m
     */
    public void restoreMemento(Memento m)
    {
        this.setState(m.getState());
    }
}
