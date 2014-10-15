package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.EntidadBancariaDAO;
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
    JSONConverter jsonConverter;

    @RequestMapping(value = {"/entidadBancaria/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadBancariaDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/entidadBancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        entidadBancariaDAO.insert(jsonConverter.fromJSON(jsonEntrada, EntidadBancaria.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/entidadBancaria"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        entidadBancariaDAO.update(jsonConverter.fromJSON(jsonEntrada, EntidadBancaria.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/entidadBancaria"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
    
    @RequestMapping(value = {"/entidadBancaria/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        entidadBancariaDAO.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
