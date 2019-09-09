package com.xjm.demo.vistor;

/**
 * 抽象元素类
 *
 */
public interface Element {
    void accept(Visitor visitor);
}
