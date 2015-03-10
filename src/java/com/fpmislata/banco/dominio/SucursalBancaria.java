package com.fpmislata.banco.dominio;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Manu
 */
public class SucursalBancaria {

    private int id;
    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;
    @NotNull
    @Size(min = 3, max = 50)
    private String poblacion;
    @NotNull
    private int codigoPostal;
    @NotNull
    @Size(min = 3, max = 50)
    private String telefono;
    @NotNull
    private int idEntidad;
    @NotNull
    @Past
    private Date fecha;

    public SucursalBancaria() {
    }

    public SucursalBancaria(int id, String nombre, String poblacion, int codigoPostal, String telefono, int idEntidad) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.idEntidad = idEntidad;
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

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
