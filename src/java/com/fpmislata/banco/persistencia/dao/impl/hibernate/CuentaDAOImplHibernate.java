/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class CuentaDAOImplHibernate extends GenericDAOImplHibernate<Cuenta> implements CuentaDAO {

    

    @Override
    public List<Cuenta> getBySucursal(int idSucursal) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT c FROM Cuenta c WHERE c.idSucursal=?");
        query.setInteger(0, idSucursal);
        List<Cuenta> cuentas = query.list();
        return cuentas;
    }
}
