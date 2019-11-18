package com.xjm.demo;

import com.xjm.demo.annotation.Logger;
import com.xjm.demo.jvm.TestClass;
import com.xjm.demo.thread.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        String s="abc";
        String s1=new String("abc");
        String s2=new String("abc");
        String s3=new String(s);
        System.out.println(s=="abc");
        System.out.println(s==s1.intern());
        System.out.println(s1==s2.intern());
        System.out.println(s==s3.intern());
        System.out.println(s1==s3.intern());

}}
