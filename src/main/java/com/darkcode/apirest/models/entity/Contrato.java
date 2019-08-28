package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Estrategia estrategia;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private FormaPago formaPago;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private PlanPago planPago;

	@Basic
	@NotNull(message = "La fecha no puede ser vacio")
	@Temporal(TemporalType.DATE)
	private Date fechaContrato;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Asesor asesor;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Titular titular;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Alumno alumno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public PlanPago getPlanPago() {
		return planPago;
	}

	public void setPlanPago(PlanPago planPago) {
		this.planPago = planPago;
	}

	public Contrato() {
	}

	public Contrato(Long id,Date fechaContrato, Asesor asesor, Titular titular, Alumno alumno,Estrategia estrategia, FormaPago formaPago, PlanPago planPago) {
		this.id = id;
		this.estrategia = estrategia;
		this.formaPago = formaPago;
		this.planPago = planPago;
		this.fechaContrato = fechaContrato;
		this.asesor = asesor;
		this.titular = titular;
		this.alumno = alumno;
	}
}
