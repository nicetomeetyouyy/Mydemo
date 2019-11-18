package com.xjm.demo.thread;

public class DeadThed implements Runnable {
    private int a,b;

    public DeadThed(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        while (true){
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){

                System.out.println(a+b);
            }
        }
    }}

}
