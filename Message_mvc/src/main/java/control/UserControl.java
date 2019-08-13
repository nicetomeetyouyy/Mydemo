package control;

import entity.Access;
import entity.Role;
import entity.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.AccessService;
import services.RoleServices;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class UserControl {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleServices roleServices;
    @Autowired
    private AccessService accessService;
   @RequestMapping("userlist")
    public String findUserAll(HttpServletRequest request, HttpServletResponse response)throws Exception{
       System.out.println("用户列表");
       List<User> list =userService.findAll();
       System.out.println(list==null);
       for (User i:list

            ) {
           System.out.println(i.getRid());
       }
       User user=userService.findByname((String) request.getSession().getAttribute("username"));
       List<Access> list_acc= accessService.findRole_acc(user.getRid());
       List<Access> list_group=accessService.findBygroup(user.getGid());
       list_acc.addAll(list_group);
       user.setAccesses(list_acc);
       request.getSession().setAttribute("User",user);
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
        User user3=userService.findByname((String) request.getSession().getAttribute("username"));
        List<Access> list_acc= accessService.findRole_acc(user.getRid());
        List<Access> list_group=accessService.findBygroup(user.getGid());
        list_acc.addAll(list_group);
        user3.setAccesses(list_acc);
        request.getSession().setAttribute("User",user3);
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
    @RequestMapping("findUser")
    public String findUser(HttpServletRequest request){
       User user = (User) request.getSession().getAttribute("User");
       List<User> list =userService.findByGid(user.getGid());
        request.getSession().setAttribute("userlist",list);
        return "users";

    }
}
