package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
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
public class EmpleadoController {

    @Autowired
    EmpleadoDAO empleadoDAO;
    @Autowired
    JSONConverter jsonConverter;

    @RequestMapping(value = {"/administrador/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(empleadoDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/administrador"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        empleadoDAO.insert(jsonConverter.fromJSON(jsonEntrada, Empleado.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/administrador"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        empleadoDAO.update(jsonConverter.fromJSON(jsonEntrada, Empleado.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/administrador"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<Empleado> entidadesBancarias = empleadoDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/administrador/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        empleadoDAO.delete(id);
        httpServletResponse.getWriter().println("ok deleted");
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = {"/administrador/password"}, method = RequestMethod.PUT)
    public void changePass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        empleadoDAO.updatePassword(jsonConverter.fromJSON(jsonEntrada, Empleado.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
