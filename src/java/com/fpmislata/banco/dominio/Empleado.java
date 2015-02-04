package com.fpmislata.banco.dominio;

import java.io.Serializable;

/**
 *
 * @author eslem
 */
public class Empleado implements Serializable{
   private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private int sucursal;

    
    public Empleado(){};
    
    public Empleado(int id){
        this.id=id;
    }
    
    public Empleado(String email, String pass){
        this.email=email;
        this.password=pass;
    }

    public Empleado(int id, String nombre, String apellidos, String dni, String direccion, String telefono, String email, String pass, int sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = pass;
        this.sucursal = sucursal;
    }
    
    public Empleado(int id, String nombre, String apellidos, String dni, String direccion, String telefono, String email, int sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sucursal = sucursal;
    }

    public Empleado(String nombre, String apellidos, String dni, String direccion, String telefono, String email, String pass, int sucursal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = pass;
        this.sucursal = sucursal;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
}