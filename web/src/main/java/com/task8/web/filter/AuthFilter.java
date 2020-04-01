package com.task8.web.filter;

import com.task8.model.Role;
import com.task8.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) rq;
        User authUser = (User)request.getSession().getAttribute("authUser");
        if(authUser == null){
            rq.getRequestDispatcher("login").forward(request, ((HttpServletResponse) rs));
        }
        filterChain.doFilter(rq, rs);
    }
}
