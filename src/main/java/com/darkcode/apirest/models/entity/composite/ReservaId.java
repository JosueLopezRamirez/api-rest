package com.darkcode.apirest.models.entity.composite;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.DetalleReserva;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ReservaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private DetalleReserva detalleReserva;
}
