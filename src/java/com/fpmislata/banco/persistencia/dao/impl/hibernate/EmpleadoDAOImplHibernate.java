/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eslem
 */
public class EmpleadoDAOImplHibernate extends GenericDAOImplHibernate<Empleado> implements EmpleadoDAO {

    PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();

    @Override
    public void updatePassword(Empleado usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("UPDATE empleados SET password=? WHERE id=?");
        query.setString(0, passwordEncrypting.encrypt(usuario.getPassword()));
        query.setInteger(1, usuario.getId());

        query.executeUpdate();
        session.close();
    }

    @Override
    public boolean checkPassword(Empleado usuario, String plainPassword) {
        return passwordEncrypting.compare(plainPassword, usuario.getPassword());
    }

    @Override
    public Empleado getByEmail(String name) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT u FROM Empleado u WHERE email=?");
        query.setString(0, name);
        query.setCacheable(true);
        return (Empleado) query.uniqueResult();
    }

    @Override
    protected void preInsert(Session session, Empleado usuario) {
        usuario.setPassword(passwordEncrypting.encrypt(usuario.getPassword()));
    }

    @Override
    protected void postGet(Session session, Empleado usuario) {
        usuario.setPassword("");
    }
}
