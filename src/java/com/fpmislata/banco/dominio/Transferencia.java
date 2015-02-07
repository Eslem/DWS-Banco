/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import java.math.BigDecimal;

/**
 *
 * @author Manu
 */
public class Transferencia {
    private int cuentaOrigen;
    private int cuentaDestino;
    private BigDecimal cantidad;

    public Transferencia(int cuentaOrigen, int cuentaDestino, BigDecimal cantidad) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.cantidad = cantidad;
    }
    
    public Transferencia(){}
  

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
