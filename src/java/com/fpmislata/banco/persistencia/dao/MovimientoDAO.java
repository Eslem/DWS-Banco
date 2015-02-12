package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Movimiento;
import com.fpmislata.banco.persistencia.common.BusinessException;
import java.util.List;

public interface MovimientoDAO extends GenericDAO<Movimiento> {

    List<Movimiento> getByIdCuenta(int idCuenta) throws BusinessException;
}
