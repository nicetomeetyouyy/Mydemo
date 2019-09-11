package com.xjm.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloAdapter {
   @Autowired
   private Hello hello;
   public void sayHi(){
       hello.satHello();
       System.out.println(hello.toString());
   }
}
