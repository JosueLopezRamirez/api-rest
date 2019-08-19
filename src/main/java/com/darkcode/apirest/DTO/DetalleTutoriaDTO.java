package com.darkcode.apirest.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DetalleTutoriaDTO {

    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;

    private Long nivel_id;
    private Long unidad_id;
    private Long tutoria_id;
    private Long tutor_id;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Long getNivel_id() {
        return nivel_id;
    }

    public void setNivel_id(Long nivel_id) {
        this.nivel_id = nivel_id;
    }

    public Long getUnidad_id() {
        return unidad_id;
    }

    public void setUnidad_id(Long unidad_id) {
        this.unidad_id = unidad_id;
    }

    public Long getTutoria_id() {
        return tutoria_id;
    }

    public void setTutoria_id(Long tutoria_id) {
        this.tutoria_id = tutoria_id;
    }

    public Long getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(Long tutor_id) {
        this.tutor_id = tutor_id;
    }

    public DetalleTutoriaDTO(){}

    public DetalleTutoriaDTO(Date fecha, Date hora, Long nivel_id, Long unidad_id, Long tutoria_id, Long tutor_id) {
        this.fecha = fecha;
        this.hora = hora;
        this.nivel_id = nivel_id;
        this.unidad_id = unidad_id;
        this.tutoria_id = tutoria_id;
        this.tutor_id = tutor_id;
    }
}
