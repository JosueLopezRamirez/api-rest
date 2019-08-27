package com.darkcode.apirest.DTO;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DetalleTutoriaDatos {

	private BigInteger id;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Temporal(TemporalType.TIME)
	private Date hora;

	private String nivel;
	private String unidad;
	private String tutoria;
	private String tutor;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getTutoria() {
		return tutoria;
	}

	public void setTutoria(String tutoria) {
		this.tutoria = tutoria;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public DetalleTutoriaDatos() {
	}

	public DetalleTutoriaDatos(BigInteger id, Date fecha, Date hora, String nivel, String unidad, String tutoria,
			String tutor) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.nivel = nivel;
		this.unidad = unidad;
		this.tutoria = tutoria;
		this.tutor = tutor;
	}
}
