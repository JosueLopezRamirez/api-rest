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
@Table(name = "correo")
public class Correo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "correo_id")
	private Long Id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id")
	private Cliente cliente;

	@Column(name = "correo", insertable = true, updatable = true, length = 15, nullable = false)
	private String Correo;

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

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Correo() {
	}

	public Correo(Long id, Cliente cliente, String correo) {
		super();
		Id = id;
		this.cliente = cliente;
		Correo = correo;
	}
}
