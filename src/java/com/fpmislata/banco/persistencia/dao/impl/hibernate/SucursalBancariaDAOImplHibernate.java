/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manu
 */
public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria> implements SucursalBancariaDAO {

    @Override
    final public List<SucursalBancaria> getByEntidad(int idEntidad) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT s FROM SucursalBancaria s WHERE s.idEntidad = ?");
        query.setInteger(0, idEntidad);
        List<SucursalBancaria> sucursalesBancarias = query.list();
        return sucursalesBancarias;
    }
}
