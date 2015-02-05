package com.fpmislata.banco.dominio;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class EntidadBancaria {

    private int id;
    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;
    @NotNull
    @Size(min = 3, max = 50)
    private String codigo;
    @NotNull
    @Past
    private Date fecha;
    //private List<SucursalBancaria> sucursales;

    public EntidadBancaria(int id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public EntidadBancaria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /*public List<SucursalBancaria> getSucursales() {
     return sucursales;
     }

     public void setSucursales(List<SucursalBancaria> sucursales) {
     this.sucursales = sucursales;
     }*/
}
