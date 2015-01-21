package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Movimiento;
import java.util.List;

public interface MovimientoDAO extends GenericDAO<Movimiento> {
    List<Movimiento> getByIdCuenta(int idCuenta);
}
