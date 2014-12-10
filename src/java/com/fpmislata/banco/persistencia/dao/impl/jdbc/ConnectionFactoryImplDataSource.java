package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.persistencia.dao.DataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Override
    public Connection getConnection() throws Exception {
        DataSource dataSource = dataSourceFactory.getDatasource();
        Connection connection = dataSource.getConnection();
        return connection;
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
