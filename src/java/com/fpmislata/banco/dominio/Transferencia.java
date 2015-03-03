/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Manu
 */
public class Transferencia {

    private int cuentaOrigen;
    private int cuentaDestino;
    private BigDecimal cantidad;
    private String concepto;
    private Date fecha;
    private String pin;
                

    public Transferencia(int cuentaOrigen, int cuentaDestino, BigDecimal cantidad, String concepto, Date fecha, String pin) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pin = pin;
    }

    public Transferencia() {
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public Movimiento getMovimientoDEBE(Cuenta cuentaBancariaOrigen){
        Movimiento movimientoMovimientoDEBE=new Movimiento();
       
            movimientoMovimientoDEBE.setConcepto(this.getConcepto());
            movimientoMovimientoDEBE.setIdCuenta(cuentaBancariaOrigen.getIdCuenta());
            movimientoMovimientoDEBE.setTipo("DEBE");
            movimientoMovimientoDEBE.setCantidad(this.getCantidad());
            
        
        return movimientoMovimientoDEBE;
    }
     
    public Movimiento getMovimientoHABER(Cuenta cuentaBancariaDestino){
        Movimiento movimientoMovimientoHABER=new Movimiento();
       
            movimientoMovimientoHABER.setConcepto("TEST");
            movimientoMovimientoHABER.setIdCuenta(cuentaBancariaDestino.getIdCuenta());
            movimientoMovimientoHABER.setTipo("HABER");
            movimientoMovimientoHABER.setCantidad(cantidad);
            
        
        return movimientoMovimientoHABER;
    }
    
}
