package com.xjm.demo.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@ComponentScan()
@Component(value = "hello")
public class Hello {
    @Value(value = "1")
    private int num;
    @Value("${num}")
    private String info;
    public void satHello(){
        System.out.println("hello World");
    }

    public Hello() {
    }

    public Hello(int num, String info) {
        this.num = num;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "num=" + num +
                ", info='" + info + '\'' +
                '}';
    }
}
