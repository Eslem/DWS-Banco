package com.fpmislata.banco.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Movimiento {

    private int id;
    private String tipo;
    private int idCuenta;
    private String concepto;
    private BigDecimal cantidad;
    private Date fecha;

    public Movimiento(){};

    public Movimiento(int id, String tipo, int idCuenta, String concepto, BigDecimal cantidad, Date fecha) {
        this.id = id;
        this.tipo = tipo;
        this.idCuenta = idCuenta;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
  
    
}
