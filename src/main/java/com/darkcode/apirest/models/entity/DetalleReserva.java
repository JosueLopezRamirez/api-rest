package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.darkcode.apirest.models.entity.composite.DetalleReservaId;

@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleReservaId id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Nivel nivel;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Unidad unidad;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tutoria tutoria;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private Tutor tutor;

	@PrePersist
	public void setFecha(){
		this.id.setFechaReserva(new Date());
	}

	public DetalleReservaId getId() { return id; }

	public void setId(DetalleReservaId id) { this.id = id; }

	public Alumno getAlumno() { return alumno; }

	public void setAlumno(Alumno alumno) { this.alumno = alumno; }

	public Nivel getNivel() { return nivel; }

	public void setNivel(Nivel nivel) { this.nivel = nivel; }

	public Unidad getUnidad() { return unidad; }

	public void setUnidad(Unidad unidad) { this.unidad = unidad; }

	public Tutoria getTutoria() { return tutoria; }

	public void setTutoria(Tutoria tutoria) { this.tutoria = tutoria; }

	public Tutor getTutor() { return tutor; }

	public void setTutor(Tutor tutor) { this.tutor = tutor; }

	public DetalleReserva() { }

	public DetalleReserva(DetalleReservaId id, Alumno alumno, Nivel nivel, Unidad unidad, Tutoria tutoria, Tutor tutor) {
		this.id = id;
		this.alumno = alumno;
		this.nivel = nivel;
		this.unidad = unidad;
		this.tutoria = tutoria;
		this.tutor = tutor;
	}
}
