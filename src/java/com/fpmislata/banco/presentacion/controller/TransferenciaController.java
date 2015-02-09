/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.dominio.Transferencia;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.TransferenciaDAOImplHibernate;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Manu
 */
@Controller
public class TransferenciaController {

    @Autowired
    TransferenciaDAOImplHibernate transferencia;
    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    CuentaDAO cuenta;

    @RequestMapping(value = {"/transferencia"}, method = RequestMethod.POST)
    public void insertTransferencia(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {

        Transferencia trans = jsonConverter.fromJSON(jsonEntrada, Transferencia.class);
        Cuenta cuentaOrigen = cuenta.get(trans.getCuentaOrigen());
        Cuenta cuentaDestino = cuenta.get(trans.getCuentaDestino());

        if ((cuentaDestino != null) && (cuentaOrigen != null)) {
            if (cuentaDestino.getPin() == trans.getPin()) {
                transferencia.generarTransferencia(jsonConverter.fromJSON(jsonEntrada, Transferencia.class));
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            }

        }

    }

}
