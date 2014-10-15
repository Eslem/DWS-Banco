package com.fpmislata.banco.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Movimiento {

    private int idMovimiento;
    private String tipo;
    private int cuentaOrigen;
    private int cuentaDestino;
    private BigDecimal cantidad;
    private Date fecha;

    public Movimiento(int idMovimiento, String tipo, int cuentaOrigen, int cuentaDestino, BigDecimal cantidad, Date fecha) {
        this.idMovimiento = idMovimiento;
        this.tipo = tipo;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
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
}
