package com.example.boot.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "adminPermissionFilter",urlPatterns= {"/admin/*"})
public class AdminPermissionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        System.out.println(servletRequest.getRequestURI());

        if(servletRequest.getRequestURI().contains("/admin/login") ||
                servletRequest.getRequestURI().contains("/admin/api/login")
        ){
            filterChain.doFilter(request, servletResponse);
        } else  {
            Object o = servletRequest.getSession().getAttribute("admin_id");
            if(o == null){
                HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
                servletResponse1.sendRedirect("/admin/login");
            } else {
                filterChain.doFilter(request, servletResponse);
            }
        }



    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
