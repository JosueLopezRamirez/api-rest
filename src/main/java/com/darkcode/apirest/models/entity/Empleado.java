package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@OneToOne
	private Persona persona;

	@Column(name = "salario", insertable = true, updatable = true)
	private float salario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Empleado() {}

	public Empleado(long id, Persona persona, float salario) {
		super();
		this.id = id;
		this.persona = persona;
		this.salario = salario;
	}
}
