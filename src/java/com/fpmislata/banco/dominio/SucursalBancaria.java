/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

/**
 *
 * @author Manu
 */
public class SucursalBancaria {
    
    private int id;
    private String nombre;
    private String poblacion;
    private int codigoPostal;
    private String telefono;
    private int idEntidad;

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
    
    
    
    
    
}
