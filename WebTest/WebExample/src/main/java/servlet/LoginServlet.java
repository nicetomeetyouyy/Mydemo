package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name =req.getParameter("user_name");
        HttpSession hs =req.getSession();
        if(" ".equals(name)||null==name){
            resp.getWriter().println("<script>" +
                    "alert(\"不能为空\")"
                    +"</script>");
            resp.sendRedirect("index.jsp");

        }else {
            hs.setAttribute("username", name);
            resp.sendRedirect("add.jsp");
        }
    }
}
