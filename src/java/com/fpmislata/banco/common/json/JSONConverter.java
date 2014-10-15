/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.common.json;

/**
 *
 * @author eslem
 */
public interface JSONConverter<T> {
    
    public String toJSON(Object obj);
    
    public T fromJSON(String json, Class<T> className);
    
}
