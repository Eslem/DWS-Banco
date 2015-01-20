package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAOImplJDBC implements CuentaDAO{
    
    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();

    @Override
    public Cuenta get(int idCuenta) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM cuentas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCuenta);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cuenta cuentaBancaria = new Cuenta(
                        resultSet.getInt("id"),
                        resultSet.getBigDecimal("saldo"),
                        resultSet.getInt("idsucursal"),
                        resultSet.getString("tipo"),
                        resultSet.getInt("cliente")
                );
                connection.close();
                return cuentaBancaria;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Cuenta insert(Cuenta cuenta) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "INSERT INTO cuentas (saldo, idsucursal, tipo, cliente) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, cuenta.getSaldoCuenta());
            preparedStatement.setInt(2, cuenta.getIdSucursal());
            preparedStatement.setString(3, cuenta.getTipoCuenta());
            preparedStatement.setInt(4, cuenta.getClienteCuenta());
            preparedStatement.executeUpdate();
            connection.close();
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idCuenta) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "DELETE FROM cuentas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCuenta);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Cuenta> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "SELECT * FROM cuentas";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (resultSet.next()) {
                cuentas.add(new Cuenta(
                        resultSet.getInt("id"),
                        resultSet.getBigDecimal("saldo"),
                        resultSet.getInt("idsucursal"),
                        resultSet.getString("tipo"),
                        resultSet.getInt("cliente")
                ));
                
            }
            connection.close();
            return cuentas;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

@Override
    public Cuenta update(Cuenta cuenta) {
        try {
            Connection connection = connectionFactory.getConnection();
            String query = "UPDATE cuentas SET saldo = ?, idsucursal = ?, tipo = ?, cliente = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, cuenta.getSaldoCuenta());
            preparedStatement.setInt(2, cuenta.getIdSucursal());
            preparedStatement.setString(3, cuenta.getTipoCuenta());
            preparedStatement.setInt(4, cuenta.getClienteCuenta());
            preparedStatement.setInt(5, cuenta.getIdCuenta());
            preparedStatement.executeUpdate();
            connection.close();
            return null; 

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Cuenta> getBySucursal(int idSucursal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}