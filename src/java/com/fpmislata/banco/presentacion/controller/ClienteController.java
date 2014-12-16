package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
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
public class ClienteController {

    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    JSONConverter jsonConverter;

    @RequestMapping(value = {"/usuario/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        
        httpServletResponse.getWriter().println(jsonConverter.toJSON(clienteDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        
          
    }

    @RequestMapping(value = {"/usuario"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
       
        clienteDAO.insert(jsonConverter.fromJSON(jsonEntrada, Cliente.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
      

    }

    @RequestMapping(value = {"/usuario"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        clienteDAO.update(jsonConverter.fromJSON(jsonEntrada, Cliente.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<Cliente> entidadesBancarias = clienteDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        clienteDAO.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario/password"}, method = RequestMethod.PUT)
    public void changePass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        clienteDAO.updatePassword(jsonConverter.fromJSON(jsonEntrada, Cliente.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
