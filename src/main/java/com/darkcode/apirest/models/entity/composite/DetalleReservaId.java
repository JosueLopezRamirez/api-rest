package com.darkcode.apirest.models.entity.composite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.darkcode.apirest.models.entity.Nivel;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Tutoria;
import com.darkcode.apirest.models.entity.Unidad;

@Embeddable
public class DetalleReservaId implements Serializable {

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date FechaReserva;

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

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	private static final long serialVersionUID = 1L;
}
