package com.xjm.demo.pojo;

import com.xjm.demo.annotation.Logger;

@Logger(value = "people",age = 0)
public class People {
    @Logger(value = "name",age = 2)
    private String name;
    @Logger(value = "age",age = 11)
    private int age;
}
