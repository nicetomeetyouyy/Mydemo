package control;

import entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserControl {
    @Autowired
    private UserService userService;
   @RequestMapping("userlist")
    public String findUserAll(HttpServletRequest request, HttpServletResponse response)throws Exception{
       List<User> list =userService.findAll();
      /* for (User i:list

            ) {
           System.out.println(i.getUser_name());
       }*/

       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
       response.setContentType("text/html,charset=utf-8");
       request.getSession().setAttribute("userlist",list);

       return "users";
    }

    @RequestMapping("updateUser")
    public String updateUser(HttpServletRequest request){
        String name =(String)request.getSession().getAttribute("username");
        User user =userService.findByname(name);
        request.getSession().setAttribute("User",user);
        System.out.println(user.getUser_name());
        return "addUser";
    }
    @RequestMapping(value = "updatetoUser",method = RequestMethod.GET)
    public String updateToUser(HttpServletRequest request){
       String name=request.getParameter("uname");
       String pwd=request.getParameter("pwd");
       String email=request.getParameter("email");
       String phone=request.getParameter("phone");
        User user1 =userService.findByname(name);
       User user=new User();
       user.setId(user1.getId());
       user.setUser_name(name);
       user.setPwd(pwd);
       user.setEmail(email);
       user.setPhone(phone);
       System.out.println("charu"+user.getUser_name());
       System.out.println(user.getId());
       userService.updateUser(user);
        List<User> list =userService.findAll();
        request.getSession().setAttribute("userlist",list);

        return "users";
    }
    @RequestMapping("LogginOut")
    public String LogginOut(HttpServletRequest request){
       request.getSession().invalidate();
       return "index";
    }
}
