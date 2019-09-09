package com.xjm.demo.memento;

/**
 * 备忘录
 */
public class Memento {
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }

    private String state;
}
