package com.darkcode.apirest.DTO;

public class ReservaAlumno {

    private String id;
    private String nombre;
    private boolean activo;
    private Short nivel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public ReservaAlumno() { }

    public ReservaAlumno(String id, String nombre, boolean activo, Short nivel) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.nivel = nivel;
    }
}
