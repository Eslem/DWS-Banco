package com.fpmislata.banco.presentacion.filter.security;

import java.io.IOException;
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
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String sessionUrl = httpServletRequest.getContextPath() + "/api/session";
        httpsession = httpServletRequest.getSession();
        
        if (httpServletRequest.getRequestURI().equals(sessionUrl)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (httpsession.getAttribute("id") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }
}
