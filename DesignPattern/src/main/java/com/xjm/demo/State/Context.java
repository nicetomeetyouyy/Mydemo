package com.xjm.demo.State;

/**
 * 环境类
 */
public class Context {
    private State state;

    /**
     * 设置状态
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 获得状态
     * @return State
     */
    public State getState() {
        return state;
    }

    /**
     * 对请求处理
     */
    public void Handle(){
        this.state.Handle(this);
    }
}
