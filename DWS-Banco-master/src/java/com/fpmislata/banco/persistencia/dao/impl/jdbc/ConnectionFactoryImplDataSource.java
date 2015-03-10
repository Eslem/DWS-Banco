package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.persistencia.dao.impl.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() throws Exception {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) context.lookup("jdbc/datasource");
            Connection connection = dataSource.getConnection();

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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
