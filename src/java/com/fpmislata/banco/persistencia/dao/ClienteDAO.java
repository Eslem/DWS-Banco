/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Cliente;

/**
 *
 * @author eslem
 */
public interface ClienteDAO extends GenericDAO<Cliente>{
    void updatePassword(Cliente usuario);
    boolean checkPassword(Cliente usuario,String plainPassword);
    Cliente getByEmail(String email);
}
