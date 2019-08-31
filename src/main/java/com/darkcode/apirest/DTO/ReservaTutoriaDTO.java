package com.darkcode.apirest.DTO;

import java.util.Date;

public class ReservaTutoriaDTO {

    private String alumno_id;
    private Long detalle_id;
    private boolean reprogramada;
    private boolean aprovada;

    public String getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(String alumno_id) {
        this.alumno_id = alumno_id;
    }

    public Long getDetalle_id() {
        return detalle_id;
    }

    public void setDetalle_id(Long detalle_id) {
        this.detalle_id = detalle_id;
    }

    public boolean isReprogramada() {
        return reprogramada;
    }

    public void setReprogramada(boolean reprogramada) {
        this.reprogramada = reprogramada;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public ReservaTutoriaDTO(){}

    public ReservaTutoriaDTO(String alumno_id, Long detalle_id, boolean reprogramada, boolean aprovada) {
        this.alumno_id = alumno_id;
        this.detalle_id = detalle_id;
        this.reprogramada = reprogramada;
        this.aprovada = aprovada;
    }

    @Override
    public String toString() {
        return "ReservaTutoriaDTO{" +
                "alumno_id='" + alumno_id + '\'' +
                ", detalle_id=" + detalle_id +
                ", reprogramada=" + reprogramada +
                ", aprovada=" + aprovada +
                '}';
    }
}
