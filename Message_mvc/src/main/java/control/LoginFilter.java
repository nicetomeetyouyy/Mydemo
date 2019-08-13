package control;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Autowired
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name=(String)request.getSession().getAttribute("username");
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
