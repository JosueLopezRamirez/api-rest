package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.darkcode.apirest.models.entity.composite.ContratoId;
import com.darkcode.apirest.models.entity.composite.ContratoId;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContratoId contratoId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Estrategia estrategia;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private FormaPago formaPago;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private PlanPago planPago;

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
