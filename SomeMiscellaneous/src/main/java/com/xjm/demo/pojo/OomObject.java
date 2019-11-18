package com.xjm.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class OomObject {
    public byte[] p=new byte[64*1024];

    public static void fillHeap(int num) throws InterruptedException {
        List<OomObject> list=new ArrayList<>();
        for (int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OomObject());
            System.gc();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
