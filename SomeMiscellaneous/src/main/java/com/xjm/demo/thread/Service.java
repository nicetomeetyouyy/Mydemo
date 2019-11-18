package com.xjm.demo.thread;

public class Service {
    public static void print(String name){
        try {
            synchronized (name){
                while (true){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            }}
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
