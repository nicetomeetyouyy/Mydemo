package servlet;



import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class AddShop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String thing =req.getParameter("thing");

     if (null==thing||" ".equals(thing)||"".equals(thing)){
         resp.setCharacterEncoding("UTF-8");
         resp.setContentType("text/html;charset=utf-8");
         resp.getWriter().println("<script>" +
                 "window.location.href = \"add.jsp\";"
                 +"</script>");
     }
        double a =Math.random()*100;
        DecimalFormat df = new DecimalFormat("0.00");
        String price = df.format(a);
        Cookie cookie=new Cookie(URLEncoder.encode(thing,"UTF-8"),price);
        resp.addCookie(cookie);
        resp.sendRedirect("Car.jsp");
    }
}
