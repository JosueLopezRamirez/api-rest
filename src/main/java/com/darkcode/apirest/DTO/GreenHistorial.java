package com.darkcode.apirest.DTO;

public class GreenHistorial {

	private Short id;
	private String tutoria;
	private Boolean aprobada;
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTutoria() {
		return tutoria;
	}

	public void setTutoria(String tutoria) {
		this.tutoria = tutoria;
	}

	public Boolean getAprobada() {
		return aprobada;
	}

	public void setAprobada(Boolean aprobada) {
		this.aprobada = aprobada;
	}

	public GreenHistorial() {}

	public GreenHistorial(Short id, String tutoria, Boolean aprobada) {
		super();
		this.id = id;
		this.tutoria = tutoria;
		this.aprobada = aprobada;
	}

}
