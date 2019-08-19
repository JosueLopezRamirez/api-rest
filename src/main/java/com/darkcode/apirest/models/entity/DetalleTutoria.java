package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "detalle_tutoria")
public class DetalleTutoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date FechaReserva;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Nivel nivel;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Unidad unidad;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tutoria tutoria;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tutor tutor;

	@Basic
	@Temporal(TemporalType.TIME)
	@Column(name = "hora")
	private Date hora;

	public Date getFechaReserva() {
		return FechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Tutoria getTutoria() {
		return tutoria;
	}

	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public DetalleTutoria() { }

	public DetalleTutoria(Date fechaReserva, Date hora,Nivel nivel, Unidad unidad, Tutoria tutoria, Tutor tutor) {
		this.nivel = nivel;
		this.unidad = unidad;
		this.tutoria = tutoria;
		this.tutor = tutor;
		FechaReserva = fechaReserva;
		this.hora = hora;
	}
}
