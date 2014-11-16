/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Administrador;

/**
 *
 * @author eslem
 */
public interface AdministradorDAO extends GenericDAO<Administrador>{
    void updatePassword(Administrador usuario);
    boolean checkPassword(Administrador usuario,String plainPassword);
}
