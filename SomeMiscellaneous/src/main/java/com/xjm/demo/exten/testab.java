package com.xjm.demo.exten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class testab {
    public static void main(String[] args) {
        System.out.println("int最大正数：" + Integer.MAX_VALUE);
        System.out.println("int最大正数二进制表示：" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("int最小负数：" + Integer.MIN_VALUE);
        System.out.println("int最小负数二进制表示：" + Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println("二进制定义打印int能表示的最大数：" + 0b01111111_11111111_11111111_11111111);
        System.out.println("二进制定义打印int能表示的最小数：" + 0b10000000_00000000_00000000_00000000);

        System.out.println("43的二进制表现：" + Integer.toBinaryString(43));//结果省略了前面的0
        System.out.println("-43的二进制表现：" + Integer.toBinaryString(-43));
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE - 1);

}}
