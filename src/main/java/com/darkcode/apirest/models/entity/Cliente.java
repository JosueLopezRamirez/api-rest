package com.darkcode.apirest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "direccion", length = 200, insertable = true, updatable = true, nullable = true)
	private String Direccion;

	@Column(name = "cedula", length = 200, insertable = true, updatable = true, nullable = true)
	private String Cedula;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Persona persona;

	@Column(name = "estado",nullable = false)
	private Boolean estado;

	@PrePersist
	public void persistEstado() {
		this.estado = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	// Constructor
	public Cliente() {}

	public Cliente(String direccion, String cedula, Persona persona,Boolean estado) {
		Direccion = direccion;
		Cedula = cedula;
		this.persona = persona;
		this.estado = estado;
	}
}
