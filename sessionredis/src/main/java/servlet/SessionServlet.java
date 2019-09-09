package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hresq= (HttpServletResponse) res;
        System.out.println(hreq.getRemoteAddr());
        System.out.print(hreq.getRemoteHost() + " : " + hreq.getRemotePort());

        String sesssionID = hreq.getSession().getId();
        System.out.println("-----------tomcat2---sesssionID-------" + sesssionID);

        String testKey = (String)hreq.getSession().getAttribute("testKey");
        System.out.println("-----------tomcat2-testKey-------" + testKey);

        PrintWriter out = null;
        try {
            out =hresq.getWriter();
            out.append("tomcat2 ---- sesssionID : " + sesssionID);
            out.append("{\"name\":\"dufy2\"}" + "\n");
            out.append("tomcat2 ----- testKey : " + testKey + "\n");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
        }


    }
}
