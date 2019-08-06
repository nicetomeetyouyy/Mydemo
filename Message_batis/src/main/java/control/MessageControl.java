package control;

import entity.Message;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.MessageService;
import services.UserService;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration

public class MessageControl {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String toMessageList(HttpServletRequest request, HttpServletResponse response){
        String name =request.getParameter("username");
        System.out.println(name);
        if(name!=null){
        request.getSession().setAttribute("username",name);}
        if(userService.findByname(name)==null){
            User user=new User();
            user.setUser_name(name);
            user.setPwd("123456");
            userService.insertUser(user);
            request.getSession().setAttribute("User",user);
            return "addUser";
        }else {
            User user =userService.findByname(name);
            request.getSession().setAttribute("use_id",user.getId());
            List<Message> list=messageService.findAll();
            System.out.println(list.size());
            request.getSession().setAttribute("messList",list);
            return "melist";
        }

    }

    @RequestMapping("melist")
    public String messList(HttpServletRequest request){
        List<Message> list=messageService.findAll();
        request.getSession().setAttribute("messList",list);
        return  "melist";
    }


    @RequestMapping(value="/deleteMessage")
    public String deleteMessage (HttpServletRequest request){
        String id =request.getParameter("delete_id");
        if(id !=null){
            messageService.deleteMessage(Integer.valueOf(id));
        }
        List<Message> list=messageService.findAll();
        request.getSession().setAttribute("messList",list);
        return "melist";
    }

    @RequestMapping("addMessage")
    public String addMessage (){
        return "addMessage";
    }
    @RequestMapping(value = "/newMessage",method = RequestMethod.POST)
   public String newMessage(HttpServletRequest request){
        String title=request.getParameter("title");
        String content =request.getParameter("content");
        int use_id=(Integer) request.getSession().getAttribute("use_id");
        Message m =new Message();
        if(title!=null&&content!=null){
        m.setTitle(title);
        m.setContent(content);
        m.setUse_id(use_id);
        System.out.println(use_id+"用户");
        messageService.insertMessage(m);
        }
        List<Message> list=messageService.findAll();
        request.getSession().setAttribute("messList",list);
        return "melist";
   }
    @RequestMapping("findMessageByuser")
   public String findMessageByuser(HttpServletRequest request){
        String username =request.getParameter("serchmessage");
        User user =userService.findByname(username);
        List<Message> list=messageService.findByuse_id(user.getId());
        request.getSession().setAttribute("messList",list);
        return "melist";
   }

}
