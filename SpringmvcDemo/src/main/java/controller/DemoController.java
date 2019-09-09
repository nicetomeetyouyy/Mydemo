package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DemoController {
    /**
     * 测试mvc搭建是否成功
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
//        return "successs";
//        正确写法
//    return "forward:WEB-INF/view/successs.jsp";
//  错误写法 return "forward:WEB-INF/view/successs";
//   return "redirect:returnMAV";
        return "forward:returnMAV";
        }


    /**
     * 测试空返回值
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request,HttpServletResponse response) throws Exception {
//      response.sendRedirect("hello");
       request.getRequestDispatcher("hello").forward(request,response);
    }

    /**
     * 返回值ModelAndView对象
     * @return
     */
    @RequestMapping("returnMAV")
    public ModelAndView returnMAV(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user","haha");
        mv.addObject("age",1);
        mv.setViewName("successs");
        return mv;
    }



}
