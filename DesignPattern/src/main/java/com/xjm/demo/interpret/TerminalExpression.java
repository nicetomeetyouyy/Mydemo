package com.xjm.demo.interpret;

import com.xjm.demo.vistor.Element;

import java.util.HashSet;
import java.util.Set;

/**
 * 终结符表达式类
 */
public class TerminalExpression implements Expression {
    private Set<String> stringSet=new HashSet<String>();

    /**
     * 将语句加入表达式里
     * @param date
     */
    public TerminalExpression(String[] date){
        for (int i=0;i<date.length;i++){
            stringSet.add(date[i]);
        }
    }

    /**
     * 对表达式进行处理
     * @param info
     * @return
     */
    public boolean interpret(String info) {
        if(stringSet.contains(info)){
            return true;
        }
        else{
            return false;
    }}
}
