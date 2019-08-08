package control;

import entity.Role;
import entity.User;
import mapper.RoleMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.RoleServices;
import services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserControl {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleServices roleServices;
   @RequestMapping("userlist")
    public String findUserAll(HttpServletRequest request, HttpServletResponse response)throws Exception{
       List<User> list =userService.findAll();
      /* for (User i:list

            ) {
           System.out.println(i.getRid());
       }*/
       List<Role> list1=  roleServices.findAll();
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
       response.setContentType("text/html,charset=utf-8");
       request.getSession().setAttribute("userlist",list);
       request.getSession().setAttribute("roleList",list1);
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
       System.out.println("修改个人信息的ID"+user1.getId());
       user.setUser_name(name);
       user.setPwd(pwd);
       user.setEmail(email);
       user.setPhone(phone);
       user.setRid(user1.getRid());
       user.setGid(user1.getGid());
       System.out.println("charu"+user.getUser_name());
       System.out.println(user.getRid()+"角色");
       userService.updateUser(user);
        List<Role> list1=  roleServices.findAll();
        List<User> list =userService.findAll();
        request.getSession().setAttribute("userlist",list);
        request.getSession().setAttribute("roleList",list1);
        return "users";
    }
    @RequestMapping("LogginOut")
    public String LogginOut(HttpServletRequest request){
       request.getSession().invalidate();
       return "index";
    }
    @RequestMapping("updateUserAll")
    public String updateUserAll(HttpServletRequest request){
       String name=request.getParameter("name");
       User users =userService.findByname(name);
       request.getSession().setAttribute("up_user",users);
       return "up_Users";
    }
    @RequestMapping("updateToUser")
    public String updatetoUser(HttpServletRequest request){
       String name=request.getParameter("uname");
       String pwd=request.getParameter("pwd");
       String email=request.getParameter("email");
       String phone =request.getParameter("phone");
       String role =request.getParameter("role");
       String gid=request.getParameter("group");
       User user1 =(User) request.getSession().getAttribute("up_user");
       int id=user1.getId();
       User user=new User(id,name,pwd,email,phone,Integer.valueOf(role),Integer.valueOf(gid));
       userService.updateUser(user);
        List<Role> list1=  roleServices.findAll();
        List<User> list =userService.findAll();
        request.getSession().setAttribute("userlist",list);
        request.getSession().setAttribute("roleList",list1);
        return "users";
    }
    @RequestMapping("userManager")
    public String userManager(HttpServletRequest request){
        List<Role> list1=  roleServices.findAll();
        request.getSession().setAttribute("roleList",list1);
       return "addNewUser";
    }
    @RequestMapping("addToUser")
    public String addToUser(HttpServletRequest request){
        String name=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String email=request.getParameter("email");
        String phone =request.getParameter("phone");
        String role =request.getParameter("role");
        String gid=request.getParameter("group");
        User user=new User(name,pwd,email,phone,Integer.valueOf(role),Integer.valueOf(gid));
        userService.insertUser(user);
        List<Role> list1=  roleServices.findAll();
        List<User> list =userService.findAll();
        request.getSession().setAttribute("userlist",list);
        request.getSession().setAttribute("roleList",list1);
        return "users";
    }
    @RequestMapping("userDelete")
    public String deleteUser(HttpServletRequest request){
       String id= request.getParameter("id");
       userService.deleteUser(Integer.valueOf(id));
        List<Role> list1=  roleServices.findAll();
        List<User> list =userService.findAll();
        request.getSession().setAttribute("userlist",list);
        request.getSession().setAttribute("roleList",list1);
        return "users";
    }
}
