package com.xjm.demo.lock;

public class Th2 extends Thread{
    private Run run;
    public Th2(Run run){
        this.run=run;
    }

    @Override
    public void run() {
        super.run();
        try {
            run.run();
            run.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Th2 Over");
    }
}
