package com.darkcode.apirest.DTO;

import java.math.BigInteger;

public class AsesorNames {
	
	private BigInteger id;
	private String nombre;
	private String apellido;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public AsesorNames() {}

	public AsesorNames(BigInteger id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
}
