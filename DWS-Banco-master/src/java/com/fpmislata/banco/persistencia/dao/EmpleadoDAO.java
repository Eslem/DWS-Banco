/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.common.BusinessException;

/**
 *
 * @author eslem
 */
public interface EmpleadoDAO extends GenericDAO<Empleado> {

    void updatePassword(Empleado usuario) throws BusinessException;

    boolean checkPassword(Empleado usuario, String plainPassword) throws BusinessException;

    Empleado getByEmail(String email) throws BusinessException;
}
