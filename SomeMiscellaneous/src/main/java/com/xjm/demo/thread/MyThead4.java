package com.xjm.demo.thread;

public class MyThead4 extends Thread{
    private Addsome addsome;
    public MyThead4(Addsome addsome) {
        this.addsome = addsome;
    }



    @Override
    public void run() {
        for (int i=0;i<500;i++){
            try {
                addsome.add(1);
//                System.out.println("二");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }}
}
