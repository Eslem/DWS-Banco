package com.fpmislata.banco.dominio;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Movimiento {

    private int id;
   // @NotNull
   // @Size(min = 3, max = 50)
    private String tipo;
   // @NotNull
    private int idCuenta;
   // @NotNull
   // @Size(min = 3, max = 50)
    private String concepto;
    //@NotNull
    private BigDecimal cantidad;
   // @NotNull
   // @Past
    private Date fecha;

    public Movimiento() {
    }

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
