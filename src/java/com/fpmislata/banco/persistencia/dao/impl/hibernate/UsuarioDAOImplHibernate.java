/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import com.fpmislata.banco.persistencia.hibernate.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery("UPDATE usuarios SET password=? WHERE id=?");
        query.setString(0, passwordEncrypting.encrypt(usuario.getPassword()));
        query.setInteger(1, usuario.getId());

        query.executeUpdate();
        session.close();
    }

    @Override
    public boolean checkPassword(Usuario usuario, String plainPassword) {
        return passwordEncrypting.compare(plainPassword, usuario.getPassword());
    }

    @Override
    protected void preInsert(Session session, Usuario usuario) {
        usuario.setPassword(passwordEncrypting.encrypt(usuario.getPassword()));
    }

    @Override
    protected void postGet(Session session, Usuario usuario) {
        usuario.setPassword("");
    }

    @Override
    public Usuario getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT u FROM Usuario u WHERE nombre=?");
        query.setString(0, name);
        query.setCacheable(true);
        return (Usuario) query.uniqueResult();
    }
}
