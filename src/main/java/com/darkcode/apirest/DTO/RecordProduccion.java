package com.darkcode.apirest.DTO;

import java.util.Date;

public class RecordProduccion {

    private Date fecha;
    private String titular;
    private String titular_id;
    private float inscripcion;
    private float plan;
    private float mensualidad;
    private float valorTotal;
    private String Asesor;
    private String Alumno;
    private String estrategia;
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
    

    public String getTitular_id() {
		return titular_id;
	}

	public void setTitular_id(String titular_id) {
		this.titular_id = titular_id;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	public RecordProduccion(){}

	public RecordProduccion(Date fecha, String titular, String titular_id, float inscripcion, float plan,
			float mensualidad, float valorTotal, String asesor, String alumno, String estrategia, String forma,
			String organizacion) {
		super();
		this.fecha = fecha;
		this.titular = titular;
		this.titular_id = titular_id;
		this.inscripcion = inscripcion;
		this.plan = plan;
		this.mensualidad = mensualidad;
		this.valorTotal = valorTotal;
		Asesor = asesor;
		Alumno = alumno;
		this.estrategia = estrategia;
		this.forma = forma;
		Organizacion = organizacion;
	}

    
}
