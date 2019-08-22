package com.darkcode.apirest.DTO;

import java.math.BigInteger;

public class DatosTitular {

    private String titular_id;
    private BigInteger cliente_id;
    private BigInteger persona_id;
    private String nombre;
    private String direccion;
    private String cedula;
    private float salario;
    private String nombreTrabajo;
    private String direccionTrabajo;
    private String telefonoTrabajo;
    private String telefonoPersonal;
    private String correoPersonal;

    public String getTitular_id() {
        return titular_id;
    }

    public void setTitular_id(String titular_id) {
        this.titular_id = titular_id;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public DatosTitular(){}

    public DatosTitular(String titular_id, BigInteger cliente_id, BigInteger persona_id, String nombre, String direccion, String cedula, float salario, String nombreTrabajo, String direccionTrabajo, String telefonoTrabajo, String telefonoPersonal, String correoPersonal) {
        this.titular_id = titular_id;
        this.cliente_id = cliente_id;
        this.persona_id = persona_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.salario = salario;
        this.nombreTrabajo = nombreTrabajo;
        this.direccionTrabajo = direccionTrabajo;
        this.telefonoTrabajo = telefonoTrabajo;
        this.telefonoPersonal = telefonoPersonal;
        this.correoPersonal = correoPersonal;
    }
}
