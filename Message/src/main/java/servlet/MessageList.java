package servlet;

import dao.MessageDao;
import dao.UserDao;
import list.Message;
import list.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/melist")
public class MessageList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String uri=req.getRequestURI();
          System.out.println(uri);
        MessageDao md =new MessageDao();
        resp.setContentType("text/html,charset=utf-8");

        List<Message> list=md.findAll();
        req.setAttribute("messList",list);

        String userid=req.getParameter("delete_id");
        System.out.println(userid);
        String user_mess=req.getParameter("serchmessage");

        if(user_mess!=null){
            list =md.findByUsername(user_mess);
            req.setAttribute("messList",list);
        }
        if(userid!=null){
            int id =Integer.valueOf(userid);
            md.deleteMessage(id);
            list =md.findAll();
            req.setAttribute("messList",list);
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("melist.jsp");
        requestDispatcher.forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String name =(String)session.getAttribute("username");
        UserDao userDao=new UserDao();
        User user =userDao.findByName(name);
        int user_id=user.getid();
        String title =req.getParameter("title");
        String content=req.getParameter("content");
        MessageDao messageDao=new MessageDao();
     ;


        if (messageDao.insertMessage(title,content,user_id)){

            List<Message> list=messageDao.findAll();
            req.setAttribute("messList",list);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("melist.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            resp.sendRedirect("addMessage,jsp");
        }}
    }

