package com.xjm.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    HelloService helloService;
    public void say(){
        helloService.sayHello("xjm");
    }
}
