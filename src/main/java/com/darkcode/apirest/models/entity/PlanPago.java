package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class PlanPago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "valorTotal", insertable = true, updatable = true, nullable = false)
	private float ValorTotal;

	@Column(name = "inscripcion", insertable = true, updatable = true, nullable = true)
	private float Inscripcion;

	@Column(name = "costoMensual", insertable = true, updatable = true, nullable = true)
	private float CostoMensual;

	@Column(name = "cantidadMeses", insertable = true, updatable = true, nullable = true)
	private float CantidadMeses;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public float getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(float valorTotal) {
		ValorTotal = valorTotal;
	}

	public float getInscripcion() {
		return Inscripcion;
	}

	public void setInscripcion(float inscripcion) {
		Inscripcion = inscripcion;
	}

	public float getCostoMensual() {
		return CostoMensual;
	}

	public void setCostoMensual(float costoMensual) {
		CostoMensual = costoMensual;
	}

	public float getCantidadMeses() {
		return CantidadMeses;
	}

	public void setCantidadMeses(float cantidadMeses) {
		CantidadMeses = cantidadMeses;
	}

	public PlanPago() {
	}

	public PlanPago(Long id, float valorTotal, float inscripcion, float costoMensual, float cantidadMeses) {
		super();
		Id = id;
		ValorTotal = valorTotal;
		Inscripcion = inscripcion;
		CostoMensual = costoMensual;
		CantidadMeses = cantidadMeses;
	}
}
