/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.servicio.impl;

import com.fpmislata.banco.servicio.Authorization;

/**
 *
 * @author eslem
 */
public class AuthorizationImplFilter implements Authorization{

    @Override
    public boolean authorizedURI(Object user, String url) {
        return false;
    }
    
}
