package com.xjm.demo;

public class HelloService {
    HelloProperties helloProperties;
    public String sayHello(String name){
        return helloProperties.getPrefix()+"  "+name+"   "+helloProperties.getSufix();
    }

    public HelloService(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
