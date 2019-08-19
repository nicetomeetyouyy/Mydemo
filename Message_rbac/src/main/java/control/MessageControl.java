package control;

import annotation.Log;
import entity.Access;
import entity.Image;
import entity.Message;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.AccessService;
import services.ImageService;
import services.MessageService;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller


public class MessageControl {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccessService accessService;
    @Autowired
    private ImageService imageService;
    @Log(operationName = "用户登录")
    @RequestMapping("login")
    public String toMessageList(HttpServletRequest request) {
        String name =request.getParameter("username");
        String pwd=request.getParameter("pwd");
//        System.out.println(pwd);
        User user=new User();
        if(name!=null&&pwd!=null){
            request.getSession().setAttribute("username",name);
            user=userService.findLogin(name,pwd);

        }
        if(user==null){
                return "index";
        }else{

            List<Access> list_acc= accessService.findRole_acc(user.getRid());
            /*for (Access a:list_acc
            ) {
                System.out.println(a.getId()+a.getName()+"c权限");
            }*/
            List<Access> list_group=accessService.findBygroup(user.getGid());
            List<Access> allAcc=accessService.findAll();
            list_acc.addAll(list_group);
           /* for (Access a:list_acc
                  ) {
                System.out.println(a.getId()+a.getName()+"chadaode quanxian");
            }*/
            user.setAccesses(list_acc);
            request.getSession().setAttribute("User",user);
            List<Message> list=messageService.findAll();
            List<User> list1 =userService.findAll();
            int id=user.getId();
//             List<Image> list2=imageService.findByUser(3);
//             System.out.println(list2.size()+"adada");
            Image image=imageService.findOne(id,1);
            if(image!=null){
                request.getSession().setAttribute("useImage",image);
                System.out.println(image.getFilename());
            }
//            System.out.println(image.getIs_used()+"adada");
            request.getSession().setAttribute("userlist",list1);
            request.getSession().setAttribute("messList",list);
            request.getSession().setAttribute("allAcc",allAcc);
            return  "melist";

        }

    }

    @RequestMapping("melist")
    public String messList(HttpServletRequest request){
        User user=userService.findByname((String) request.getSession().getAttribute("username"));
        List<Access> list_acc= accessService.findRole_acc(user.getRid());
        List<Access> list_group=accessService.findBygroup(user.getGid());
        list_acc.addAll(list_group);
        user.setAccesses(list_acc);
        request.getSession().setAttribute("User",user);
        List<Message> list=messageService.findAll();
        List<User> list1 =userService.findAll();
        request.getSession().setAttribute("userlist",list1);
        request.getSession().setAttribute("messList",list);
        List<Access> allAcc=accessService.findAll();
        request.getSession().setAttribute("allAcc",allAcc);
        int id=user.getId();
        Image image=imageService.findOne(id,1);
        if(image!=null){
            request.getSession().setAttribute("useImage",image);
            System.out.println(image.getFilename());
        }
        return  "melist";
    }

    @Log(operationName = "删除留言")
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
    @Log(operationName = "新建留言")
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
    @Log(operationName = "查找留言")
    @RequestMapping("findMessageByuser")
   public String findMessageByuser(HttpServletRequest request){
        String username =request.getParameter("serchmessage");

        User user =userService.findByname(username);
        List<Message> list=messageService.findByuse_id(user.getId());
        request.getSession().setAttribute("messList",list);
        System.out.println(username);
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
   @Log(operationName = "修改留言")
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
   @Log(operationName = "查看小组留言")
   @RequestMapping("groupMess")
    public String groupMess(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("User");
        int gid =user.getGid();
        List<User> users =userService.findByGid(gid);
        System.out.println(users.size()+"查到的用户");
        List<Message> list1=new ArrayList<Message>();
        for (int i=0;i<users.size();i++){
            int id=users.get(i).getId();
            System.out.println(id+"用户ID");
            List<Message> list =messageService.findByuse_id(id);
            list1.addAll(list);
            System.out.println("woliuyan");
        }
       request.getSession().setAttribute("groupList",list1);
       return "groupList";
   }
}
