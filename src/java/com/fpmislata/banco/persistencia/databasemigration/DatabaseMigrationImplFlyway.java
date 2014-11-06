/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.databasemigration;

import org.flywaydb.core.Flyway;

/**
 *
 * @author eslem
 */
public class DatabaseMigrationImplFlyway implements DatabaseMigration{

    @Override
    public void migrate(String databaseurl) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(databaseurl, "root", "root");
        flyway.setLocations("com.fpmislata.banco.persistencia.databasemigration.migrations");
        flyway.migrate();
    }    
}
