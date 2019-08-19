package com.darkcode.apirest.models.entity.composite;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.models.entity.Titular;

@Embeddable
public class ContratoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Asesor asesor;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Titular titular;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Alumno alumno;

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public ContratoId(){}

	public ContratoId(Asesor asesor, Titular titular, Alumno alumno) {
		this.asesor = asesor;
		this.titular = titular;
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((asesor == null) ? 0 : asesor.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoId other = (ContratoId) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (asesor == null) {
			if (other.asesor != null)
				return false;
		} else if (!asesor.equals(other.asesor))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}
	
	
}
