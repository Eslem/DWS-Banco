package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
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
public class MovimientoController {

    @Autowired
    MovimientoDAO movimientoDAO;
    @Autowired
    JSONConverter jsonConverter;
    
    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(movimientoDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/movimiento"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        movimientoDAO.insert(jsonConverter.fromJSON(jsonEntrada, Movimiento.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/movimiento"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        movimientoDAO.update(jsonConverter.fromJSON(jsonEntrada, Movimiento.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/movimiento"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<Movimiento> entidadesBancarias = movimientoDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
    
    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        movimientoDAO.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
    
   
    
}
