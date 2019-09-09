package com.xjm.demo.State;

/**
 * B状态
 */
public class StateB implements State {

    public void Handle(Context context) {
        System.out.println("我是B状态");
        context.setState(new StateA());

    }
}
