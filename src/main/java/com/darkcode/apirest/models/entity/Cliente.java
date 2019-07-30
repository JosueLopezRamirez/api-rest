package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Telefono> telefono;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Correo> correo;

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

	public List<Telefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}

	public List<Correo> getCorreo() {
		return correo;
	}

	public void setCorreo(List<Correo> correo) {
		this.correo = correo;
	}

	// Constructor
	public Cliente() {}

	public Cliente(String direccion, String cedula, Persona persona, List<Telefono> telefono, List<Correo> correo) {
		Direccion = direccion;
		Cedula = cedula;
		this.persona = persona;
		this.telefono = telefono;
		this.correo = correo;
	}
}
