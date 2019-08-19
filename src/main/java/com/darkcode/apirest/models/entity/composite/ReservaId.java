package com.darkcode.apirest.models.entity.composite;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.DetalleTutoria;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ReservaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private DetalleTutoria detalleTutoria;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public DetalleTutoria getDetalleTutoria() {
        return detalleTutoria;
    }

    public void setDetalleTutoria(DetalleTutoria detalleTutoria) {
        this.detalleTutoria = detalleTutoria;
    }

    public ReservaId(){}

    public ReservaId(Alumno alumno, DetalleTutoria detalleTutoria) {
        this.alumno = alumno;
        this.detalleTutoria = detalleTutoria;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((detalleTutoria == null) ? 0 : detalleTutoria.hashCode());
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
		ReservaId other = (ReservaId) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (detalleTutoria == null) {
			if (other.detalleTutoria != null)
				return false;
		} else if (!detalleTutoria.equals(other.detalleTutoria))
			return false;
		return true;
	}
    
    
}
