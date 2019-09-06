package com.xjm.demo.composite;
//测试
public class compositeClient {
    public static void main(String[] args) {
        Branch b1=new Branch();
        Branch b2=new Branch();
        Tree l1=new Leaf("1");
        Tree l2=new Leaf("2");
        Tree l3=new Leaf("3");
        b1.add(l1);
        b1.add(b2);
        b2.add(l2);
        b2.add(l3);
        b1.show();
        System.out.println("_____________________");
        b2.show();
    }
}
