package com.xjm.demo.shoses;

import com.xjm.demo.sharepart.InsolePart;
import com.xjm.demo.sharepart.LacePart;
import com.xjm.demo.sharepart.SolePart;
import com.xjm.demo.sharepart.TonguePart;

public  class Shoes {
    private String color;
    private SolePart sole;
    private TonguePart tongue;
    private LacePart lace;
    private InsolePart insole;

    public Shoes() {
    }

    public Shoes(String color, SolePart sole, TonguePart tongue, LacePart lace, InsolePart insole) {
        this.color = color;
        this.sole = sole;
        this.tongue = tongue;
        this.lace = lace;
        this.insole = insole;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public SolePart getSole() {
        return sole;
    }

    public void setSole(SolePart sole) {
        this.sole = sole;
    }

    public TonguePart getTongue() {
        return tongue;
    }

    public void setTongue(TonguePart tongue) {
        this.tongue = tongue;
    }

    public LacePart getLace() {
        return lace;
    }

    public void setLace(LacePart lace) {
        this.lace = lace;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "color='" + color + '\'' +
                ", sole=" + sole.getCorlor() +sole.getPart()+
                ", tongue=" + tongue.getCorlor() +tongue.getPart()+
                ", lace=" + lace.getCorlor() +lace.getPart()+
                ", insole=" + insole.getCorlor() +insole.getPart()+
                '}';
    }

    public InsolePart getInsole() {
        return insole;
    }

    public void setInsole(InsolePart insole) {
        this.insole = insole;
    }
}
