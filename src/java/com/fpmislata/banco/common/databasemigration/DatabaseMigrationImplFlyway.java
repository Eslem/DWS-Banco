/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.common.databasemigration;

import org.flywaydb.core.Flyway;

/**
 *
 * @author eslem
 */
public class DatabaseMigrationImplFlyway implements DatabaseMigration{

    @Override
    public void migrate(String datasourceName,String packageName) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(datasourceName, "root", "root");
        flyway.setLocations(packageName);
        flyway.migrate();
    }    
}
