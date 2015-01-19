/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.SucursalBancaria;
import java.util.List;

/**
 *
 * @author Manu
 */
public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria> {

    public List<SucursalBancaria> getByEntidad(int idEntidad);
}
