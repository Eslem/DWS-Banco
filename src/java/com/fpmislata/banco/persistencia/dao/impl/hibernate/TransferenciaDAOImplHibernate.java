/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.Transferencia;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manu
 */
public class TransferenciaDAOImplHibernate extends GenericDAOImplHibernate<Transferencia> {

    public void generarTransferencia(Transferencia transferencia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        /*Query querycuenta = session.createSQLQuery("SELECT * FROM CUENTAS WHERE id=?");
        querycuenta.setInteger(0,transferencia.getCuentaOrigen());
        List list = querycuenta.list();*/
        
        Query querydebe = session.createSQLQuery("INSERT INTO movimientos (tipo,idCuenta,concepto,cantidad,fecha) VALUES (?,?,?,?,?)");
        querydebe.setString(0, "DEBE");
        querydebe.setInteger(1, transferencia.getCuentaOrigen());
        querydebe.setString(2, transferencia.getConcepto());
        querydebe.setBigDecimal(3, transferencia.getCantidad());
        querydebe.setDate(4, new Date());
        querydebe.executeUpdate();

        Query queryhaber = session.createSQLQuery("INSERT INTO movimientos (tipo,idCuenta,concepto,cantidad,fecha) VALUES (?,?,?,?,?)");
        queryhaber.setString(0, "HABER");
        queryhaber.setInteger(1, transferencia.getCuentaDestino());
        queryhaber.setString(2, transferencia.getConcepto());
        queryhaber.setBigDecimal(3, transferencia.getCantidad());
        queryhaber.setDate(4, new Date());
        queryhaber.executeUpdate();
    };
    
   

}
