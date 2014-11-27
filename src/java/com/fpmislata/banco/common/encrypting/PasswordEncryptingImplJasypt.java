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
    public String encrypt(String password) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.encryptPassword(password);
    }

    @Override
    public boolean compare(String password, String encryptedPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.checkPassword(password, encryptedPassword);
    }
}
