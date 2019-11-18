package com.xjm.demo.sington;

/**
 * 静态内置类实现单例
 */
public class My1 {
    private static class MyHandler{
        private static My1 my1=new My1();
    }
    public My1(){
    }
     public static My1 getInstance() {
        return MyHandler.my1;
    }
}
