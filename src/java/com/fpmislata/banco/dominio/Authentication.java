/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.persistencia.dao.AdministradorDAO;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class Authentication {

    @Autowired
    AdministradorDAO administradorDAO;
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    PasswordEncrypting passwordEncrypting;

    public boolean authenticateUser(Credentials credentials) {
        Usuario usuario = usuarioDAO.getByName(credentials.getLogin());

        return passwordEncrypting.compare(credentials.getPassword(), usuario.getPassword());
    }
}
