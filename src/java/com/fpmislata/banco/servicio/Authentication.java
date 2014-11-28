/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.servicio;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.dominio.Credentials;
import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.dao.AdministradorDAO;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class Authentication {

    @Autowired
    PasswordEncrypting passwordEncrypting;
    @Autowired
    AdministradorDAO administradorDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    public boolean authenticateUser(Credentials credentials) {
        Usuario usuario = usuarioDAO.getByName(credentials.getLogin());

        return passwordEncrypting.compare(credentials.getPassword(), usuario.getPassword());
    }
}
