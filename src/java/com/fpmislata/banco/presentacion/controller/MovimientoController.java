package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JSONConverter;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.common.BusinessException;
import com.fpmislata.banco.persistencia.common.BusinessMessage;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import com.fpmislata.banco.persistencia.dao.CuentaDAO;
import com.fpmislata.banco.persistencia.dao.MovimientoDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
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

    private void catchException(HttpServletResponse httpServletResponse, Exception ex) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(jsonConverter.toJSON(ex));
    }

    private boolean updateSaldoCuenta(HttpServletResponse httpServletResponse, Movimiento movimiento) throws IOException {
        try {
            /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.getTransaction().rollback();*/
            int idCuenta = movimiento.getIdCuenta();
            if (idCuenta != 0) {
                Cuenta cuenta = cuentaDAO.get(idCuenta);
                BigDecimal saldoNuevo = movimiento.getCantidad();
                BigDecimal saldoViejo = cuenta.getSaldoCuenta();
                if (movimiento.getTipo().equalsIgnoreCase("Debe"))
                    saldoNuevo = saldoNuevo.multiply(new BigDecimal(-1));
                saldoNuevo = saldoViejo.add(saldoNuevo);
                if (saldoNuevo.compareTo(BigDecimal.ZERO) > 0) {
                    cuenta.setSaldoCuenta(saldoNuevo);
                    return true;
                }
            }
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }

        return false;
    }

    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().println(jsonConverter.toJSON(movimientoDAO.get(id)));
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/movimiento"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        try {
            Movimiento movimiento = jsonConverter.fromJSON(jsonEntrada, Movimiento.class);
            if (updateSaldoCuenta(httpServletResponse, movimiento)) {
                movimientoDAO.insert(movimiento);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                throw new BusinessException(new BusinessMessage(null, "El saldo del movimiento es mayor al disponible en la cuenta"));
            }
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/movimiento"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            List<Movimiento> entidadesBancarias = movimientoDAO.findAll();
            httpServletResponse.getWriter().println(jsonConverter.toJSON(entidadesBancarias));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }

    @RequestMapping(value = {"/movimiento/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id) throws IOException {
        try {
            movimientoDAO.delete(id);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (BusinessException ex) {
            catchException(httpServletResponse, ex);
        }
    }
}
