package com.fpmislata.banco.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Movimiento {

    private int id;
    private String tipo;
    private int cuentaOrigen;
    private int cuentaDestino;
    private String descripcion;
    private BigDecimal cantidad;
    private Date fecha;

    public Movimiento(){};
    public Movimiento(int id, String tipo, int cuentaOrigen, int cuentaDestino, String descripcion, BigDecimal cantidad, Date fecha) {
        this.id = id;
        this.tipo = tipo;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.descripcion=  descripcion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdMovimiento() {
        return id;
    }

    public void setIdMovimiento(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
