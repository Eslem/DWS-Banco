/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.listener.migration;

import com.fpmislata.banco.persistencia.dao.DataSourceFactory;
import com.fpmislata.banco.persistencia.migration.DatabaseMigration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author eslem
 */
public class ServletContextListenerImplMigration implements ServletContextListener {

    @Autowired
    DatabaseMigration databaseMigration;

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
        DataSource dataSource = dataSourceFactory.getDatasource();
        databaseMigration.migrate(dataSource, "com.fpmislata.banco.persistencia.migration.migrations");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
