package com.darkcode.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@ManyToOne(optional = false)
	private Cliente cliente;

	@Column(name = "telefono", insertable = true, updatable = true, length = 50, nullable = false)
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
