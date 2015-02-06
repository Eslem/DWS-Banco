/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.servicio.Authentication;
import com.fpmislata.banco.dominio.Credentials;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import java.io.IOException;
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
    EmpleadoDAO empleadoDAO;
    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    Authentication authentication;

    private HttpSession httpsession;

    private void catchException(HttpServletResponse httpServletResponse, Exception ex) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(jsonConverter.toJSON(ex));
    }

    @RequestMapping(value = {"/session"}, method = RequestMethod.POST)
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            httpsession = httpServletRequest.getSession(true);

            Credentials credentials = jsonConverter.fromJSON(jsonEntrada, Credentials.class);
            int userId = authentication.authenticateUser(credentials);

            if (userId != 0) {
                try {
                    httpsession.setAttribute("id", userId);
                    httpServletResponse.getWriter().print(jsonConverter.toJSON(empleadoDAO.get(userId)));
                    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/session"}, method = RequestMethod.DELETE)
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpsession = httpServletRequest.getSession(true);
        httpsession.invalidate();
        //httpsession.removeAttribute("id");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/session"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            httpsession = httpServletRequest.getSession(true);
            if (httpsession.getAttribute("id") != null) {
                int id = (int) httpsession.getAttribute("id");

                if (id != 0) {
                    httpServletResponse.getWriter().print(jsonConverter.toJSON(empleadoDAO.get(id)));
                    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                } else {
                    httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }
}
