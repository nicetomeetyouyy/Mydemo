package com.xjm.demo.lock;

public class Th1 extends Thread {
    private Run run;
    public Th1(Run run){
        this.run=run;
    }

    @Override
    public void run() {
        super.run();
        try {
            run.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Th1 Over");
    }
}
