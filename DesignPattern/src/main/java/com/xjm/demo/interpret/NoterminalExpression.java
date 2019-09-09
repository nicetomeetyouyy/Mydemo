package com.xjm.demo.interpret;

/**
 * 非终结类表达式
 */
public class NoterminalExpression implements Expression{
    private Expression city;
    private Expression person;

    public NoterminalExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    /**
     * 非对终结符表达式的处理
     * @param info
     * @return
     */
    public boolean interpret(String info) {
        String s[]=info.split("的");
        return city.interpret(s[0])&&person.interpret(s[1]);
    }
}
