package com.xjm.demo.thread;

public class StringThread1 extends Thread {
    private Service service;
    public StringThread1(Service service){
        this.service=service;
            }
    @Override
    public void run() {
        super.run();
        Service.print("AA");
    }
}
