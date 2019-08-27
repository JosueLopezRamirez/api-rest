package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_tutoria")
public class DetalleTutoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "No puede ser vacio")
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@NotNull(message = "La fecha no puede ser vacio")
	@Temporal(TemporalType.TIME)
	@Column(name = "hora")
	private Date hora;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Nivel nivel;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Unidad unidad;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tutoria tutoria;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tutor tutor;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public DetalleTutoria(Long id,Date fecha, Date hora,Nivel nivel, Unidad unidad, Tutoria tutoria, Tutor tutor) {
		this.id = id;
		this.nivel = nivel;
		this.unidad = unidad;
		this.tutoria = tutoria;
		this.tutor = tutor;
		this.fecha = fecha;
		this.hora = hora;
	}
}
