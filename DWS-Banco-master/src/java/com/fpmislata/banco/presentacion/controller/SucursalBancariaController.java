/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Manu
 */
@Controller
public class SucursalBancariaController {

    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    CuentaDAO cuentaDAO;

    private void catchException(HttpServletResponse httpServletResponse, Exception ex) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(jsonConverter.toJSON(ex));
    }

    @RequestMapping(value = {"/sucursalbancaria/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().println(jsonConverter.toJSON(sucursalBancariaDAO.get(id)));
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/sucursalbancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            sucursalBancariaDAO.insert(jsonConverter.fromJSON(jsonEntrada, SucursalBancaria.class));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/sucursalbancaria"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            sucursalBancariaDAO.update(jsonConverter.fromJSON(jsonEntrada, SucursalBancaria.class));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/sucursalbancaria"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            List<SucursalBancaria> entidadesBancarias = sucursalBancariaDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/sucursalbancaria/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            sucursalBancariaDAO.delete(id);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }
}
