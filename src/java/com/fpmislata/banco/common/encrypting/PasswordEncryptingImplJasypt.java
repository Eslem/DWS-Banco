/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.common.encrypting;

import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author eslem
 */
public class PasswordEncryptingImplJasypt implements PasswordEncrypting {

    @Override
    public String encrypt(String pass) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.encryptPassword(pass);
    }

    @Override
    public boolean compare(String pass, String encyptedPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(pass);
        return passwordEncryptor.checkPassword(encyptedPassword, encryptedPassword);
    }

}
