package com.xjm.demo.memento;

public class MementoTest {


    public static void main(String[] args) {
        Originnator originnator=new Originnator();
        Caretaker caretaker=new Caretaker();
        originnator.setState("状态1");
        caretaker.setMemento(originnator.createMemento());
        System.out.println(originnator.getState());
        originnator.setState("状态2");
        System.out.println(originnator.getState());
        originnator.restoreMemento(caretaker.getMemento());
        System.out.println(originnator.getState());
    }
}
