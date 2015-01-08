/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.persistencia.dao.DataSourceFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author eslem
 */
public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDatasource() {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
           DataSource dataSource = (DataSource) context.lookup("jdbc/MySQLDS");
            return dataSource;
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

}
