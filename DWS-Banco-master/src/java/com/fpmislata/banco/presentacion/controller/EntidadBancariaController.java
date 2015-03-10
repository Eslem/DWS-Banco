package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
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

@Controller
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    @Autowired
    JSONConverter jsonConverter;

    private void catchException(HttpServletResponse httpServletResponse, Exception ex) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(jsonConverter.toJSON(ex));
    }

    @RequestMapping(value = {"/entidadBancaria/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadBancariaDAO.get(id)));
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/entidadBancaria/"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            entidadBancariaDAO.insert(jsonConverter.fromJSON(jsonEntrada, EntidadBancaria.class));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/entidadBancaria/"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            entidadBancariaDAO.update(jsonConverter.fromJSON(jsonEntrada, EntidadBancaria.class));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/entidadBancaria/"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/entidadBancaria/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            entidadBancariaDAO.delete(id);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/entidadBancaria/{id}/sucursalesBancarias"}, method = RequestMethod.GET)
    public void getSucursalesBancarias(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJSON(sucursalBancariaDAO.getByEntidad(id)));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }
}
