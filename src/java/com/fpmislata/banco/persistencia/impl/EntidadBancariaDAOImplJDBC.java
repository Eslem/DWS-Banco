package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.ConnectionFactory;
import com.fpmislata.banco.persistencia.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(
                        resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getString("codigoEntidad")
                );
                connection.close();
                return entidadBancaria;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "INSERT INTO entidadbancaria (nombre, codigoEntidad, fechaCreacion) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.executeUpdate();
            connection.close();
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "UPDATE entidadbancaria SET nombre = ?, codigoEntidad = ? WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setInt(3, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            connection.close();
            return null; /* PENDING */

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idEntidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idEntidadBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM entidadbancaria";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<EntidadBancaria> entidadesBancarias = new ArrayList<EntidadBancaria>();
            while (resultSet.next()) {
                entidadesBancarias.add(new EntidadBancaria(
                        resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getString("codigoEntidad")
                ));
            }
            connection.close();
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
