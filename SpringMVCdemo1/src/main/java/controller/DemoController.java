package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String testDemo(){
        return "index";
    }
    @RequestMapping("demo/{id}/{name}")
    public String testRestful(@PathVariable int id,@PathVariable("name")String name2){
        System.out.println(id+name2);
        return "/index";
    }
    @RequestMapping("demo2")
    public String testRedict(){
        return "redirect:WEB-INF/view/index";
    }
    @RequestMapping("demo3")
    public String testForward(){
        return "forward:WEB-INF/view/index";
    }
}
