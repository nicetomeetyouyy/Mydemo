package com.xjm.demo.chain;

/**
 * 组装请求处理
 */
public class ChainClient {
    public static void main(String[] args) {

        Handler h1=new ConcreteHandler1();
        Handler h2=new ConcreteHandler2();
        h1.setNext(h2);
        h1.handleRequest(1);
        h1.handleRequest(2);
        h1.handleRequest(-1);
    }
}
