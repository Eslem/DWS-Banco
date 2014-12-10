/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.listener.hibernate;

import com.fpmislata.banco.persistencia.hibernate.HibernateUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author alumno
 */
public class ServletContextListenerImplHibernate implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       HibernateUtil.buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       HibernateUtil.closeSessionFactory();
    }
    
}
