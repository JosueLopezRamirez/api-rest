package com.darkcode.apirest.DTO;

import java.util.Date;

public class ReservaTutoriaDTO {

    private String alumno_id;
    private Date fecha_reserva;
    private boolean reprogramada;
    private boolean aprovada;

    public String getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(String alumno_id) {
        this.alumno_id = alumno_id;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
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

    public ReservaTutoriaDTO(String alumno_id, Date fecha_reserva, boolean reprogramada, boolean aprovada) {
        this.alumno_id = alumno_id;
        this.fecha_reserva = fecha_reserva;
        this.reprogramada = reprogramada;
        this.aprovada = aprovada;
    }
}
