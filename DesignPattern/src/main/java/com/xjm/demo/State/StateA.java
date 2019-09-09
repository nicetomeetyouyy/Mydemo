package com.xjm.demo.State;

/**
 * A状态
 */
public class StateA implements State {
    public void Handle(Context context)
    {
        System.out.println("我是A状态");
        context.setState(new StateB());
    }
}
