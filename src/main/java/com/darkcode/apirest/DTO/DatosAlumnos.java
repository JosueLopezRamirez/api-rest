package com.darkcode.apirest.DTO;

import java.math.BigInteger;

public class DatosAlumnos {

    private String alumno_id;
    private BigInteger cliente_id;
    private BigInteger persona_id;
    private String nombre;
    private String direccion;
    private String cedula;
    private Short nivel;
    private Boolean activo;
    private String telefono;
    private String correo;

    public String getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(String alumno_id) {
        this.alumno_id = alumno_id;
    }

    public BigInteger getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(BigInteger cliente_id) {
        this.cliente_id = cliente_id;
    }

    public BigInteger getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(BigInteger persona_id) {
        this.persona_id = persona_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DatosAlumnos() { }

    public DatosAlumnos(String alumno_id, BigInteger cliente_id, BigInteger persona_id, String nombre, String direccion, String cedula, Short nivel, Boolean activo, String telefono, String correo) {
        this.alumno_id = alumno_id;
        this.cliente_id = cliente_id;
        this.persona_id = persona_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.nivel = nivel;
        this.activo = activo;
        this.telefono = telefono;
        this.correo = correo;
    }
}
