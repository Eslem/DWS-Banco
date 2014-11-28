package com.fpmislata.banco.presentacion.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterImplSecurity implements Filter {

    FilterConfig filterConfig = null;
    private HttpSession httpsession;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String sessionUrl = httpServletRequest.getContextPath()+"/api/session";
        
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(sessionUrl);
        
        httpsession = httpServletRequest.getSession();
        if (httpsession.getAttribute("name")!=null || httpServletRequest.getRequestURI().equals(sessionUrl)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setStatus(403);
        }
    }
}
