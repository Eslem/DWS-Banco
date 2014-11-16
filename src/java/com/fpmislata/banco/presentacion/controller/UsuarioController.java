package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import com.fpmislata.banco.persistencia.dao.impl.UsuarioDAOImplHibernate;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    JSONConverter jsonConverter;

    @RequestMapping(value = {"/usuario/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(usuarioDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        usuarioDAO.insert(jsonConverter.fromJSON(jsonEntrada, Usuario.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        usuarioDAO.update(jsonConverter.fromJSON(jsonEntrada, Usuario.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<Usuario> entidadesBancarias = usuarioDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable int id) throws IOException {
        usuarioDAO.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/usuario/password"}, method = RequestMethod.PUT)
    public void changePass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        usuarioDAO.updatePassword(jsonConverter.fromJSON(jsonEntrada, Usuario.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
