/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eslem
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO {

    PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();

    @Override
    public void updatePassword(Usuario usuario) {
        Session session = getSessionFactory().openSession();
        Query query = session.createSQLQuery("UPDATE usuarios SET pass=? WHERE id=?");
        query.setString(0, passwordEncrypting.encrypt(usuario.getPass()));
        query.setInteger(1, usuario.getId());
        
        query.executeUpdate(); 
        session.close();
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
    }
;

}
