package com.xjm.demo.interpret;

/**
 * 环境类
 */
public class Context {
    private String[] citys={"厦门","集美"};
    private String[] persons={"老人","妇女","儿童"};
    private  Expression cityPerson;

    /**
     * 数据初始化
     */
    public Context() {
        Expression city=new TerminalExpression(citys);
        Expression person=new TerminalExpression(persons);
        cityPerson=new NoterminalExpression(city,person);
    }

    /**
     * 调用相关表达式类的解释方法
     * @param info
     */
    public void inteprret(String info){
        boolean flag=cityPerson.interpret(info);
        if(flag){
            System.out.println("您是"+info+",在我们翻译范围");
        }else {
            System.out.println("您是"+info+",不在我们翻译范围");
        }
    }
}
