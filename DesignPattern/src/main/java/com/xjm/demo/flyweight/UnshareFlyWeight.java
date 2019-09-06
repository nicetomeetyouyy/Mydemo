package com.xjm.demo.flyweight;
//不可共享的形状
public class UnshareFlyWeight {
    private String unShare;

    public UnshareFlyWeight(String share) {
        this.unShare = share;
    }

    public String getShare() {
        return unShare;
    }

    public void setShare(String share) {
        this.unShare = share;
    }
}
