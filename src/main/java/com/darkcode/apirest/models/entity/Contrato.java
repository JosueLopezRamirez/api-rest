package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.darkcode.apirest.models.entity.composite.ContratoId;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContratoId contratoId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Estrategia estrategia;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private FormaPago formaPago;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private PlanPago planPago;

	@NotNull(message = "La fecha no puede ser vacio")
	@Temporal(TemporalType.DATE)
	private Date fechaContrato;

	// Getters and Setters
	public ContratoId getContratoId() {
		return contratoId;
	}

	public void setContratoId(ContratoId contratoId) {
		this.contratoId = contratoId;
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

	public Contrato(ContratoId contratoId, Estrategia estrategia, FormaPago formaPago, PlanPago planPago,
			Date fechaContrato) {
		super();
		this.contratoId = contratoId;
		this.estrategia = estrategia;
		this.formaPago = formaPago;
		this.planPago = planPago;
		this.fechaContrato = fechaContrato;
	}
}
