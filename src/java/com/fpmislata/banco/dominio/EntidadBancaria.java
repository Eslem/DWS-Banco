package com.fpmislata.banco.dominio;

public class EntidadBancaria {
    private int idEntidadBancaria;
    private String nombre;
    private String codigoEntidad;
    
    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidad) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
    }

    public EntidadBancaria() {}

    /**
     * @return the idEntidadBancaria
     */
    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    /**
     * @param idEntidadBancaria the idEntidadBancaria to set
     */
    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigoEntidad
     */
    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    /**
     * @param codigoEntidad the codigoEntidad to set
     */
    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }
}
