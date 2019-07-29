package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",length = 5, insertable = true, updatable = false, nullable = false, unique = true)
	private String id;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Cliente cliente;

	@Column(name = "nivel", insertable = true, updatable = true, nullable = false)
	private short Nivel;

	@Column(name = "activo", insertable = true, updatable = true, nullable = false)
	private boolean activo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public short getNivel() {
		return Nivel;
	}

	public void setNivel(short nivel) {
		Nivel = nivel;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Alumno() {}

	public Alumno(String id, Cliente cliente, short nivel, boolean activo) {
		super();
		this.id = id;
		this.cliente = cliente;
		Nivel = nivel;
		this.activo = activo;
	}
}
