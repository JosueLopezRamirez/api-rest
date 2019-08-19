package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titular")
public class Titular implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",length = 5, insertable = true, updatable = false, nullable = false, unique = true)
	private String id;

	@Column(name = "salario", insertable = true, updatable = true, nullable = false)
	private float Salario;

	@Column(name = "nombreTrabajo", length = 100, insertable = true, updatable = true, nullable = true)
	private String NombreTrabajo;

	@Column(name = "direccionTrabajo", length = 200, insertable = true, updatable = true, nullable = true)
	private String DireccionTrabajo;

	@Column(name = "telefonoTrabajo", length = 40, insertable = true, updatable = true, nullable = true)
	private String TelefonoTrabajo;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Cliente cliente;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getSalario() {
		return Salario;
	}

	public void setSalario(float salario) {
		Salario = salario;
	}

	public String getNombreTrabajo() {
		return NombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		NombreTrabajo = nombreTrabajo;
	}

	public String getDireccionTrabajo() {
		return DireccionTrabajo;
	}

	public void setDireccionTrabajo(String direccionTrabajo) {
		DireccionTrabajo = direccionTrabajo;
	}

	public String getTelefonoTrabajo() {
		return TelefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		TelefonoTrabajo = telefonoTrabajo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Titular() {
	}

	public Titular(String id, float salario, String nombreTrabajo, String direccionTrabajo, String telefonoTrabajo,
			Cliente cliente) {
		super();
		this.id = id;
		Salario = salario;
		NombreTrabajo = nombreTrabajo;
		DireccionTrabajo = direccionTrabajo;
		TelefonoTrabajo = telefonoTrabajo;
		this.cliente = cliente;
	}
}
