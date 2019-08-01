package servlet;

import dao.UserDao;
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

@WebServlet(urlPatterns = "/userlist")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserDao userDao=new UserDao();
        List<User> list=userDao.findALL();
        req.setAttribute("userlist",list);
        String id =req.getParameter("id");
        System.out.println(id);
        String name =req.getParameter("uname");
        System.out.println(name);
        String pwd =req.getParameter("pwd");
        System.out.println(pwd);
        String email =req.getParameter("email");
        System.out.println(email);
        String phone =req.getParameter("phone");
        System.out.println(phone);
        if(id!=null) {

        int i =Integer.valueOf(id);
         userDao.updateUser(i,name,pwd,email,phone);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("users.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserDao userDao=new UserDao();
        HttpSession session = req.getSession();
        String name =(String)session.getAttribute("username");
        User user =userDao.findByName(name);
        req.setAttribute("user",user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addUser.jsp");
        requestDispatcher.forward(req, resp);
    }
}
