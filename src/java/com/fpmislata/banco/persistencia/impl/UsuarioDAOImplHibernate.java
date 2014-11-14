/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.UsuarioDAO;
import org.hibernate.Session;

/**
 *
 * @author eslem
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO {

    PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();

    @Override
    public void updatePassword(Usuario usuario, String plainPassword) {
        usuario.setPass(passwordEncrypting.encrypt(usuario.getPass()));
        update(usuario);
    }

    @Override
    public boolean checkPassword(Usuario usuario, String plainPassword) {
        return passwordEncrypting.compare(plainPassword, usuario.getPass());
    }

    @Override
    protected void preInsert(Session session, Usuario usuario) {
         usuario.setPass(passwordEncrypting.encrypt(usuario.getPass()));
    }
    
    @Override
    protected void postGet(Session session, Usuario usuario) {
        usuario.setPass("");
    };
;

}
