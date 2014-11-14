/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.dao.GenericDAO;

/**
 *
 * @author eslem
 */
public interface UsuarioDAO extends GenericDAO<Usuario>{
    void updatePassword(Usuario usuario,String plainPassword);
    boolean checkPassword(Usuario usuario,String plainPassword);
}
