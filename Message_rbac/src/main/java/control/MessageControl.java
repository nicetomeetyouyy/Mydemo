package control;

import entity.Access;
import entity.Message;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.AccessService;
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
    @Autowired
    private AccessService accessService;

    @RequestMapping("login")
    public String toMessageList(HttpServletRequest request, HttpServletResponse response){
        String name =request.getParameter("username");
        String pwd=request.getParameter("pwd");
        System.out.println(pwd);
        User user=new User();
        if(name!=null&&pwd!=null){
        request.getSession().setAttribute("username",name);
         user =userService.findLogin(name,pwd);
        }
        if(user==null){
            return "index";
        }else{
            List<Access> list_acc= accessService.findRole_acc(user.getRid());
            List<Access> list_group=accessService.findBygroup(user.getGid());
            list_acc.addAll(list_group);
            user.setAccesses(list_acc);
            request.getSession().setAttribute("User",user);
            List<Message> list=messageService.findAll();
            request.getSession().setAttribute("messList",list);
            return  "melist";

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
//        System.out.println(content+":留言内容");
        User user = (User) request.getSession().getAttribute("User");
        Message m =new Message();
        if(title!=null&&content!=null){
        m.setTitle(title);
        m.setContent(content);
        m.setUse_id(user.getId());
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
   @RequestMapping("updateMessage")
   public String updataMessage(HttpServletRequest request){
        String id=request.getParameter("id");
        System.out.println("消息ID"+id);
        Message message = (Message) messageService.findById(Integer.valueOf(id));
        System.out.println(message.getTitle()+"标题");
        request.getSession().setAttribute("Message",message);
        return "updateToMessage";
   }
   @RequestMapping("updateToMessage")
   public String updateToMessage(HttpServletRequest request){
        String title=request.getParameter("title");
        System.out.println("我的标题:"+title);
        String content=request.getParameter("content");
        Message message=(Message)request.getSession().getAttribute("Message");
        message.setTitle(title);
        message.setContent(content);
        messageService.updateMessage(message);
       List<Message> list=messageService.findAll();
       request.getSession().setAttribute("messList",list);
       return "melist";
   }
}
