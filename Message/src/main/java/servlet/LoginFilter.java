package servlet;

import dao.UserDao;
import list.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession();
        String name =(String)session.getAttribute("username");
        if(name==null||name.equals("")||" ".equals(name)){
            resp.sendRedirect("index.jsp");

        }else {
            UserDao userDao =new UserDao();
            User user =userDao.findByName(name);
            if(user!=null) {
                session.setAttribute("user_id",user.getid());
                filterChain.doFilter(req,resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
