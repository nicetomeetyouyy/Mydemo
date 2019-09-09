package com.xjm.demo.State;

/**
 * 测试类
 */
public class StateClient {
    public static void main(String[] args) {
        Context context=new Context();
        context.setState(new StateB());
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
