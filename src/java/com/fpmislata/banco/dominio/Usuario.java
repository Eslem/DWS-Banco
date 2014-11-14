/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import java.io.Serializable;

/**
 *
 * @author eslem
 */
public class Usuario implements Serializable{
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int telefono;
    private String email;
    private String pass;
    
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
        this.pass = contraseña;
    }
    
    public Usuario(int id, String nombre, String apellidos, String dni, String direccion, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Usuario(String nombre, String apellidos, String dni, String direccion, int telefono, String email, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pass = contraseña;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }    
    
    
    
    /*-----Null pasword retrieving information
     @Override
    public void onPostLoad(PostLoadEvent ple) {
        Usuario usuario=(Usuario)ple.getEntity();
        //Nunca se retorna el Hash de la contraseña
        usuario.setContraseña(null);

    }   */

    
    
}
