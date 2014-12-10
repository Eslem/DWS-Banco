package com.fpmislata.banco.dominio;

import java.math.BigDecimal;

public class Cuenta {
    
    int idCuenta;
    
    BigDecimal saldoCuenta;
    int idSucursal;
    String tipoCuenta;
    int clienteCuenta;
    
    public Cuenta () {}
    
    public Cuenta (int idCuenta, BigDecimal saldoCuenta, int idSucursal, String tipoCuenta, int clienteCuenta){
    
        this.idCuenta = idCuenta;
        this.saldoCuenta = saldoCuenta;
        this.idSucursal = idSucursal;
        this.tipoCuenta = tipoCuenta;
        this.clienteCuenta = clienteCuenta;
        
    }
    
    public int getIdCuenta(){
        
        return idCuenta;
        
    }
    
    public void setIdCuenta(int idCuenta){
        
        this.idCuenta = idCuenta;
        
    }
    
    public BigDecimal getSaldoCuenta(){
        
        return saldoCuenta;
        
    }
    
    public void setSaldoCuenta(BigDecimal saldoCuenta){
        
        this.saldoCuenta = saldoCuenta;
        
    }
    
    public int getIdSucursal(){
        
        return idSucursal;
        
    }
    
    public void setIdSucursal(int idSucursal){
        
        this.idSucursal = idSucursal;
        
    }
    
    public String getTipoCuenta (){
        
        return tipoCuenta;
        
    }
    
    public void setTipoCuenta(String tipoCuenta){
        
        this.tipoCuenta = tipoCuenta;
        
    }
    
    public int getClienteCuenta (){
        
        return clienteCuenta;
        
    }
    
    public void setClienteCuenta(int clienteCuenta){
        
        this.clienteCuenta = clienteCuenta;
        
    }
   
}
