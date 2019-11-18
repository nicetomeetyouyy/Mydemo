package com.xjm.demo.thread;

public class StringThread2 extends Thread {
    private Service service;
    public StringThread2(Service service){
        this.service=service;
    }
    @Override
    public void run() {
        super.run();
        Service.print("AA");
    }
}
