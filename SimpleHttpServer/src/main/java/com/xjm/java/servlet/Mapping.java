package com.xjm.java.servlet;

import java.util.HashSet;
import java.util.Set;

public class Mapping {
    private String name;
    private Set<String> urlPattern;

    public Mapping() {
        urlPattern=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern.add(urlPattern) ;
    }
}
