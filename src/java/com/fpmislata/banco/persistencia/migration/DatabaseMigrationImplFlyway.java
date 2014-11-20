/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.migration;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

/**
 *
 * @author eslem
 */
public class DatabaseMigrationImplFlyway implements DatabaseMigration{

    @Override
    public void migrate(DataSource dataSource, String locations) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setEncoding("utf-8");
        flyway.setLocations(locations);
        flyway.migrate();
    }    
}
