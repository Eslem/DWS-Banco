package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    CuentaDAO cuentaDAO;
    @Autowired
    JSONConverter jsonConverter;

    private void updateSaldoCuenta(Movimiento movimiento) {
        try {
            Cuenta cuenta = cuentaDAO.get(movimiento.getIdCuenta());
            BigDecimal nuevoSaldo = movimiento.getCantidad();
            if (movimiento.getTipo().equalsIgnoreCase("Debe"))
                nuevoSaldo = nuevoSaldo.multiply(new BigDecimal(-1));
            nuevoSaldo = cuenta.getSaldoCuenta().add(nuevoSaldo);
            cuenta.setSaldoCuenta(nuevoSaldo);
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            httpServletResponse.getWriter().println(jsonConverter.toJSON(movimientoDAO.get(id)));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = {"/movimiento"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            Movimiento movimiento = jsonConverter.fromJSON(jsonEntrada, Movimiento.class);
            updateSaldoCuenta(movimiento);
            movimientoDAO.insert(movimiento);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = {"/movimiento"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            List<Movimiento> entidadesBancarias = movimientoDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            movimientoDAO.delete(id);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
