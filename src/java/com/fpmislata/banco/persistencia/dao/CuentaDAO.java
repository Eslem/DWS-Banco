package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Cuenta;
import java.util.List;

public interface CuentaDAO extends GenericDAO<Cuenta>{ 
public List<Cuenta> getBySucursal(int idSucursal);

}