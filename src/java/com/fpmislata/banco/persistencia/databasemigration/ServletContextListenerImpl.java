/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.databasemigration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author eslem
 */
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseMigration databaseMigration = new DatabaseMigrationImplFlyway();
        databaseMigration.migrate("jdbc:mysql://localhost:3306/banco");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
