/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import javax.sql.DataSource;

/**
 *
 * @author eslem
 */
public interface DataSourceFactory {
    public DataSource getDatasource();
}
