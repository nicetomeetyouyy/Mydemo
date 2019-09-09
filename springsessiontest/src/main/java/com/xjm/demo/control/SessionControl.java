package com.xjm.demo.control;

import org.hibernate.validator.constraints.pl.REGON;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class SessionControl {
    @RequestMapping("hello")
    public Map<String, Object> hello(HttpServletRequest request){

       request.getSession().setAttribute("test","session来自"+request.getRequestURL());
        Map<String,Object> map=new HashMap<>();
        map.put("test","session来自"+request.getRequestURL());
        return map;
    }
    @RequestMapping("session")
    public Object session(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String s= (String) request.getSession().getAttribute("test");
        map.put("test2",s);
        return map;
    }
}
