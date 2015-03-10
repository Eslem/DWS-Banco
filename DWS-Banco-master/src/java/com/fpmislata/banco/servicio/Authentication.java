/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.servicio;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.dominio.Credentials;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.presentacion.controller.EntidadBancariaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class Authentication {

    @Autowired
    PasswordEncrypting passwordEncrypting;
    @Autowired
    EmpleadoDAO empleadoDAO;

    public int authenticateUser(Credentials credentials) {
        try {
            Empleado empleado = empleadoDAO.getByEmail(credentials.getLogin());
            if (empleado != null) {
                if (passwordEncrypting.compare(credentials.getPassword(), empleado.getPassword())) {
                    return empleado.getId();
                }
            }
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
}
