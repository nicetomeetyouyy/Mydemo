package com.xjm.demo.iterator;

/**
 * 测试迭代器
 */
public class IteratorTest {
    public static void main(String[] args) {
        Aggregate aggregate=new ConcreteAggreate();
        aggregate.add("第一个对象");
        aggregate.add("第二个对象");
        aggregate.add("第三个对象");
        Iterator iterator=aggregate.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
