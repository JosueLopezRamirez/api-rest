package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefono_id")
	private Long Id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id")
	private Cliente cliente;

	@Column(name = "telefono", insertable = true, updatable = true, length = 15, nullable = false)
	private String Telefono;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Telefono() {
	}

	public Telefono(Long id, Cliente cliente, String telefono) {
		super();
		Id = id;
		this.cliente = cliente;
		Telefono = telefono;
	}
}
