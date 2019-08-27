package com.darkcode.apirest.DTO;

import java.math.BigInteger;

public class DatosGreen {

	private BigInteger id;
	private String telefono;
	private String correo;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public DatosGreen() {}

	public DatosGreen(BigInteger id, String telefono, String correo) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.correo = correo;
	}
	
}
