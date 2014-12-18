/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia;

/**
 *
 * @author eslem
 */
public class BusisnessMessage {
    private String propertyName;
    private String message;

    public BusisnessMessage(String propertyName, String message) {
        this.propertyName = propertyName;
        this.message = message;
    }

    public BusisnessMessage() {
    }
  
    
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
