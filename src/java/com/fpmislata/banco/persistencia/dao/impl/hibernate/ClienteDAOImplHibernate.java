/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eslem
 */
public class ClienteDAOImplHibernate extends GenericDAOImplHibernate<Cliente> implements ClienteDAO {

    PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();
    
    @Override
    public void updatePassword(Cliente usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("UPDATE clientes SET password=? WHERE id=?");
        query.setString(0, passwordEncrypting.encrypt(usuario.getPassword()));
        query.setInteger(1, usuario.getId());

        query.executeUpdate();
        session.close();
    }

    @Override
    public boolean checkPassword(Cliente usuario, String plainPassword) {
        return passwordEncrypting.compare(plainPassword, usuario.getPassword());
    }    

    @Override
    public Cliente getByEmail(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT u FROM clientes u WHERE email=?");
        query.setString(0, name);
        query.setCacheable(true);
        return (Cliente) query.uniqueResult();
    }
    
    @Override
    protected void preInsert(Session session, Cliente usuario) {
        usuario.setPassword(passwordEncrypting.encrypt(usuario.getPassword()));
    }
    
    @Override
    protected void preUpdate(Session session, Cliente usuario) {
        usuario.setPassword(passwordEncrypting.encrypt(usuario.getPassword()));
    }

    @Override
    protected void postGet(Session session, Cliente usuario) {
        usuario.setPassword("");
    }
}
