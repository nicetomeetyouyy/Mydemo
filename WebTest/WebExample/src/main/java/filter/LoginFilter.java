package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.String;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hseq = (HttpServletRequest) servletRequest;
        HttpServletResponse srpe = (HttpServletResponse) servletResponse;
        HttpSession httpSession =hseq.getSession();
        String path =hseq.getRequestURI();
        String name = (String) httpSession.getAttribute("username");
        if (path.indexOf(path)>-1){
            filterChain.doFilter(hseq,srpe);
            return;
        }
        if(name==null||"".equals(name)){
            srpe.sendRedirect("index.jsp");
        }else {
            filterChain.doFilter(hseq,srpe);
        }


    }

    @Override
    public void destroy() {

    }
}
