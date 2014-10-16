/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.common.servletlisteners;

import com.fpmislata.banco.common.databasemigration.DatabaseMigration;
import com.fpmislata.banco.common.databasemigration.DatabaseMigrationImplFlyway;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author eslem
 */
public class DatabaseMigrationListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseMigration databaseMigration = new DatabaseMigrationImplFlyway();
        databaseMigration.migrate("jdbc:mysql://localhost:3306/banco");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
