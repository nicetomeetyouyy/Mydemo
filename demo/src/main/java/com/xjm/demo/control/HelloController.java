package com.xjm.demo.control;

import com.xjm.demo.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping("hello")
    public String hello(){
        return helloService.sayHello("徐建民");
    }
}
