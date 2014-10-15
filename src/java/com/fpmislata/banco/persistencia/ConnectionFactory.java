/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia;

import java.sql.Connection;

/**
 *
 * @author eslem
 */
public interface ConnectionFactory {
    //public Connection createConnection();
    // public void closeConnection();

    public Connection getConnection() throws Exception;
    public void closeConnection(Connection connection);
}
