/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.common.encrypting;

/**
 *
 * @author eslem
 */
public interface PasswordEncrypting {
    public String encrypt(String pass);
    public boolean compare(String pass, String encyptedPassword);
}
