package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hresq= (HttpServletResponse) res;
        //设置session1111
        hreq.getSession().setAttribute("testKey", "1111");

        hreq.getSession().setMaxInactiveInterval(10*1000);

        hresq.sendRedirect(hreq.getContextPath() + "/session");


    }
}
