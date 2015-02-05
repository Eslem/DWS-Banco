/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Transferencia;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Manu
 */
public class TransferenciaController {
    @Autowired
    MovimientoDAO movimientoDAO;
    @Autowired
    JSONConverter jsonConverter;
    
   @RequestMapping(value = {"/transferencia"}, method = RequestMethod.POST)
    public void insertTransferencia(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        movimientoDAO.generarTransferencia(jsonConverter.fromJSON(jsonEntrada, Transferencia.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
    
}
