package com.darkcode.apirest.models.entity;

import com.darkcode.apirest.models.entity.composite.ReservaId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "reserva_tutoria")
public class ReservaTutoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ReservaId id;

    @Column(name = "reprogramada", nullable = true, insertable = true, updatable = true)
    private boolean reprogramada;

    @Column(name = "aprobada", nullable = true, insertable = true, updatable = true)
    private boolean aprobada;

    public ReservaId getId() {
        return id;
    }

    public void setId(ReservaId id) {
        this.id = id;
    }

    public boolean isReprogramada() {
        return reprogramada;
    }

    public void setReprogramada(boolean reprogramada) {
        this.reprogramada = reprogramada;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public ReservaTutoria(){}

    public ReservaTutoria(ReservaId id, boolean reprogramada, boolean aprobada) {
        this.id = id;
        this.reprogramada = reprogramada;
        this.aprobada = aprobada;
    }
}
