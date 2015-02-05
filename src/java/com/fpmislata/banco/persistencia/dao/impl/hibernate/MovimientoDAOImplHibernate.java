/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.dominio.Transferencia;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manu
 */
public class MovimientoDAOImplHibernate extends GenericDAOImplHibernate<Movimiento> implements MovimientoDAO{

    @Override    
    public void generarTransferencia(Transferencia transferencia){
        Session session = HibernateUtil.getSessionFactory().openSession();
         Query querydebe = session.createSQLQuery("INSERT INTO movimientos (tipo,idCuenta,cantidad) VALUES (?,?,?)");
         querydebe.setString(0,"DEBE");
         querydebe.setInteger(1,transferencia.getCuentaOrigen());
         querydebe.setBigDecimal(2, transferencia.getCantidad().negate());
         querydebe.executeUpdate();
         
         Query queryhaber = session.createSQLQuery("INSERT INTO movimientos (tipo,idCuenta,cantidad) VALUES (?,?,?)");
         queryhaber.setString(0,"HABER");
         queryhaber.setInteger(1,transferencia.getCuentaDestino());
         queryhaber.setBigDecimal(2, transferencia.getCantidad());
         queryhaber.executeUpdate();
    };

   
   
}    

