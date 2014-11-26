/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;

/**
 *
 * @author alumno
 */
public class Authentication {
    
    @Autowired 

    public boolean checkPassword( Credentials credentials) {
        PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();
        
        return passwordEncrypting.compare(,credentials.getPassword() );
    }
}
