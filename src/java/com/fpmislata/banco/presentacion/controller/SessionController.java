/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Authentication;
import com.fpmislata.banco.dominio.Credentials;
import com.fpmislata.banco.persistencia.dao.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eslem
 */
@Controller
public class SessionController {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    Authentication authentication;
    
    private HttpSession httpsession;

    @RequestMapping(value = {"/session"}, method = RequestMethod.POST)
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        httpsession = httpServletRequest.getSession(true);

        Credentials credentials = jsonConverter.fromJSON(jsonEntrada, Credentials.class);
        try {
            httpServletResponse.getWriter().println("password: " + credentials.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (authentication.authenticateUser(credentials)) {
            httpsession.setAttribute("nombre", credentials.login);
        } 
    }

    @RequestMapping(value = {"/session"}, method = RequestMethod.DELETE)
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpsession = httpServletRequest.getSession(true);
        httpsession.removeAttribute("id");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/session"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpsession = httpServletRequest.getSession();
            httpServletResponse.getWriter().println("session nombre: " + httpsession.getAttribute("nombre"));

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
