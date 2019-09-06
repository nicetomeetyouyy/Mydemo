package com.xjm.demo.shoses;

public class Shobox {
    private String logo;
    private String size;
    private String color;

    public Shobox() {
    }

    @Override
    public String toString() {
        return "Shobox{" +
                "logo='" + logo + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Shobox(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
