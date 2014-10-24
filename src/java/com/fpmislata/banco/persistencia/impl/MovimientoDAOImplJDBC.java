package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.ConnectionFactory;
import com.fpmislata.banco.persistencia.MovimientoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimientoDAOImplJDBC implements MovimientoDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();

    @Override
    public Movimiento get(int id) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM movimientos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Movimiento movimiento = new Movimiento(
                       // resultSet.getInt("id"),
                        id,
                        resultSet.getString("tipo"),
                        resultSet.getInt("cuentaOrigen"),
                        resultSet.getInt("cuentaDestino"),
                        resultSet.getString("descripcion"),
                        resultSet.getBigDecimal("cantidad"),
                        resultSet.getDate("fecha")
                );
                connection.close();
                return movimiento;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Movimiento insert(Movimiento movimiento) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "INSERT INTO movimientos (tipo,cuentaOrigen,cuentaDestino,descripcion,cantidad,fecha) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movimiento.getTipo());
            preparedStatement.setInt(2, movimiento.getCuentaOrigen());
            preparedStatement.setInt(3, movimiento.getCuentaDestino());
            preparedStatement.setString(4,movimiento.getDescripcion());
            preparedStatement.setBigDecimal(5, movimiento.getCantidad());
            preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
            preparedStatement.executeUpdate();
            connection.close();
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Movimiento update(Movimiento entidad) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "UPDATE movimientos SET tipo = ?, cuentaOrigen = ?, cuentaDestino = ?, descripcion=?, cantidad = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entidad.getTipo());
            preparedStatement.setInt(2, entidad.getCuentaOrigen());
            preparedStatement.setInt(3, entidad.getCuentaDestino());
            preparedStatement.setString(4, entidad.getDescripcion());
            preparedStatement.setBigDecimal(5, entidad.getCantidad());
            preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
            preparedStatement.executeUpdate();
            connection.close();
            return null; /* PENDING */

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "DELETE FROM movimientos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Movimiento> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM movimientos";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Movimiento> movimientos = new ArrayList<Movimiento>();
            while (resultSet.next()) {
                movimientos.add(new Movimiento(
                        resultSet.getInt("id"),
                        resultSet.getString("tipo"),
                        resultSet.getInt("cuentaOrigen"),
                        resultSet.getInt("cuentaDestino"),
                        resultSet.getString("descripcion"),
                        resultSet.getBigDecimal("cantidad"),
                        resultSet.getDate("fecha")
                ));
            }
            connection.close();
            return movimientos;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
