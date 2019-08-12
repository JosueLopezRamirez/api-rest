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
}
