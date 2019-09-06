package com.xjm.demo.observer;

/**
 * 对对象进行测试
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject=new SubjectImpl();
        Observer observer1=new ConcreteObserver1();
        Observer observer2=new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
        subject.remove(observer1);
        subject.notifyObserver();

    }
}
