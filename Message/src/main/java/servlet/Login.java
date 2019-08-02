package servlet;

import dao.MessageDao;
import dao.UserDao;
import list.Message;
import util.JdbcUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("conten-type","text/html,charset=utf-8");
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        resp.setContentType("text/html,charset=utf-8");

        UserDao ud=new UserDao();
        if (ud.findByName(name)!=null){
            HttpSession session =req.getSession();
            session.setAttribute("username",name);
            MessageDao md =new MessageDao();
            List<Message> list=md.findAll();
            req.setAttribute("messList",list);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("melist.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}