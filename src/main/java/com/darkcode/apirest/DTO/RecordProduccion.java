package com.darkcode.apirest.DTO;

import java.util.Date;

public class RecordProduccion {

    private Date fecha;
    private String titular;
    private float inscripcion;
    private float plan;
    private float mensualidad;
    private float valorTotal;
    private String Asesor;
    private String Alumno;
    private String forma;
    private String Organizacion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(float inscripcion) {
        this.inscripcion = inscripcion;
    }

    public float getPlan() {
        return plan;
    }

    public void setPlan(float plan) {
        this.plan = plan;
    }

    public float getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getAsesor() {
        return Asesor;
    }

    public void setAsesor(String asesor) {
        Asesor = asesor;
    }

    public String getAlumno() {
        return Alumno;
    }

    public void setAlumno(String alumno) {
        Alumno = alumno;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getOrganizacion() {
        return Organizacion;
    }

    public void setOrganizacion(String organizacion) {
        Organizacion = organizacion;
    }

    public RecordProduccion(){}

    public RecordProduccion(Date fecha, String titular, float inscripcion, float plan, float mensualidad, float valorTotal, String asesor, String alumno, String forma, String organizacion) {
        this.fecha = fecha;
        this.titular = titular;
        this.inscripcion = inscripcion;
        this.plan = plan;
        this.mensualidad = mensualidad;
        this.valorTotal = valorTotal;
        Asesor = asesor;
        Alumno = alumno;
        this.forma = forma;
        Organizacion = organizacion;
    }
}
