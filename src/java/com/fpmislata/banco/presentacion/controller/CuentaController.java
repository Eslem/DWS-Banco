package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
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
public class CuentaController {

    @Autowired
    CuentaDAO cuentaDAO;
    @Autowired
    MovimientoDAO movimientoDAO;
    @Autowired
    JSONConverter jsonConverter;

    @RequestMapping(value = {"/cuenta/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(cuentaDAO.get(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/cuenta/{id}/movimiento"}, method = RequestMethod.GET)
    public void getMovimiento(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        httpServletResponse.getWriter().println(jsonConverter.toJSON(movimientoDAO.getByIdCuenta(id)));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/cuenta"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        cuentaDAO.insert(jsonConverter.fromJSON(jsonEntrada, Cuenta.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/cuenta"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<Cuenta> cuentas = cuentaDAO.findAll();
        httpServletResponse.getWriter().println(jsonConverter.toJSON(cuentas));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/cuenta/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        cuentaDAO.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = {"/cuenta"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        cuentaDAO.update(jsonConverter.fromJSON(jsonEntrada, Cuenta.class));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = {"/sucursalbancaria/{id}/cuentas/"}, method = RequestMethod.GET)
    public void getCuentas(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        List<Cuenta> cuentas = cuentaDAO.getBySucursal(id);
        httpServletResponse.getWriter().println(jsonConverter.toJSON(cuentas));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
