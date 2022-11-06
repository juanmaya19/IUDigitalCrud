package com.iudigital.domain;

public class EstadoCivil {

    private int idEstadoCivil;
    private String nombre;

    public EstadoCivil() {
    }

    public EstadoCivil(int idEstadoCivil, String nombre) {
        this.idEstadoCivil = idEstadoCivil;
        this.nombre = nombre;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
