/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.filter.hibernate;

import com.fpmislata.banco.persistencia.common.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author alumno
 */
public class FilterImplHibernate implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain fc) throws IOException, ServletException {
        HibernateUtil.openSessionAndBindToThread();
        fc.doFilter(ServletRequest, ServletResponse);
        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public void destroy() {
    }
    
}
