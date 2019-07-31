package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[]coo=req.getCookies();
        if(coo.length!=0){
            for(int i=0;i<coo.length;i++){
                Cookie cookie = coo[i];
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        req.getSession().removeAttribute("username");
        resp.sendRedirect("index.jsp");
    }
}
