package servlet;



import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class AddShop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String thing =req.getParameter("thing");
     if (null==thing||" ".equals(thing)){
         resp.getWriter().println("<script>" +
                 "alert(\"验证码不能为空\")"
                 +"</script>");
     }
        double a =Math.random()*100;
        String price =String.valueOf(a);
        Cookie cookie=new Cookie(URLEncoder.encode(thing,"UTF-8"),price);
        resp.addCookie(cookie);
        resp.sendRedirect("Car.jsp");
    }
}
