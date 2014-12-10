/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Administrador;
import com.fpmislata.banco.persistencia.dao.AdministradorDAO;
import com.fpmislata.banco.persistencia.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eslem
 */
public class AdministradorDAOImplHibernate extends GenericDAOImplHibernate<Administrador> implements AdministradorDAO {

    PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();

    @Override
    public void updatePassword(Administrador usuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery("UPDATE administradores SET pass=? WHERE id=?");
        query.setString(0, passwordEncrypting.encrypt(usuario.getPassword()));
        query.setInteger(1, usuario.getId());
        
        query.executeUpdate(); 
        session.close();
    }

    @Override
    public boolean checkPassword(Administrador usuario, String plainPassword) {
        return passwordEncrypting.compare(plainPassword, usuario.getPassword());
    }

    @Override
    protected void preInsert(Session session, Administrador usuario) {
        usuario.setPassword(passwordEncrypting.encrypt(usuario.getPassword()));
    }

    @Override
    protected void postGet(Session session, Administrador usuario) {
        usuario.setPassword("");
    }
}
