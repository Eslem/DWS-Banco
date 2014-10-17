/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import com.fpmislata.banco.common.encrypting.PasswordEncrypting;
import com.fpmislata.banco.common.encrypting.PasswordEncryptingImplJasypt;

/**
 *
 * @author eslem
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int telefono;
    private String email;
    private String contraseña;
    
    private PasswordEncrypting passwordEncrypting = new PasswordEncryptingImplJasypt();
    
    public Usuario(){};
    
    public Usuario(int id){
        this.id=id;
    }

    public Usuario(int id, String nombre, String apellidos, String dni, String direccion, int telefono, String email, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = passwordEncrypting.encrypt(contraseña);
    }

    public Usuario(String nombre, String apellidos, String dni, String direccion, int telefono, String email, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = passwordEncrypting.encrypt(contraseña);
    }
    
    
    public boolean login(String pass){
        return passwordEncrypting.compare(pass, contraseña);
    }
    
    
    
}