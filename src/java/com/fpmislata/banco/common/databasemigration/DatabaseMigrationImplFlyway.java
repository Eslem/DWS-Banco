/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.common.databasemigration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.flywaydb.core.Flyway;

/**
 *
 * @author eslem
 */
public class DatabaseMigrationImplFlyway implements DatabaseMigration, ServletContextListener{

    @Override
    public void migrate(String databaseurl) {
        System.out.println(databaseurl);
        
        /*
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:h2:file:target/foobar", "sa", null);
        flyway.migrate();*/
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        migrate("migration");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
