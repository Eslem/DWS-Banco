/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.persistencia.common.BusinessException;
import java.util.List;

/**
 *
 * @author eslem
 */
public interface GenericDAO <T>{
    
    public T get(int id) throws BusinessException;
    
    public T insert(T entidad) throws BusinessException;
    
    public T update(T entidad) throws BusinessException;
    
    public void delete(int id) throws BusinessException;
    
    public List<T> findAll() throws BusinessException;
    
}
