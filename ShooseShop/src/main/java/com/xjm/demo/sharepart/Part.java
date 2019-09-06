package com.xjm.demo.sharepart;

/**
 * 抽象配件类，可定义颜色，具体配件由子类完成
 */
public abstract class Part {
    protected String corlor;
    protected String part;

    public Part(String corlor, String part) {
        this.corlor = corlor;
        this.part = part;
    }

    public Part() {
    }

    public String getCorlor() {
        return corlor;
    }

    public void  setCorlor(String corlor) {
        this.corlor = corlor;
    }

    public String getPart() {
        return part;
    }

    public abstract void setPart() ;
}
