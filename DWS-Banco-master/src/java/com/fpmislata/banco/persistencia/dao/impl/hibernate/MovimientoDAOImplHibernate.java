/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manu
 */
public class MovimientoDAOImplHibernate extends GenericDAOImplHibernate<Movimiento> implements MovimientoDAO{
    
    @Override
    public List<Movimiento> getByIdCuenta(int idCuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT m FROM Movimiento m WHERE idCuenta=?");
        query.setInteger(0, idCuenta);
        query.setCacheable(true);
        
        List<Movimiento> list = query.list();

        return list;
    }
    
}
