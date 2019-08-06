package com.darkcode.apirest.DTO;

import java.util.Date;

public class ContratoDTO {

    private String alumno_id;
    private String titular_id;
    private Long asesor_id;
    private Long estrategia_id;
    private Long plan_id;
    private Long forma_id;
    private Date fechaContrato;

    public String getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(String alumno_id) {
        this.alumno_id = alumno_id;
    }

    public String getTitular_id() {
        return titular_id;
    }

    public void setTitular_id(String titular_id) {
        this.titular_id = titular_id;
    }

    public Long getAsesor_id() {
        return asesor_id;
    }

    public void setAsesor_id(Long asesor_id) {
        this.asesor_id = asesor_id;
    }

    public Long getEstrategia_id() {
        return estrategia_id;
    }

    public void setEstrategia_id(Long estrategia_id) {
        this.estrategia_id = estrategia_id;
    }

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public Long getForma_id() {
        return forma_id;
    }

    public void setForma_id(Long forma_id) {
        this.forma_id = forma_id;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public ContratoDTO(){}

    public ContratoDTO(String alumno_id, String titular_id, Long asesor_id, Long estrategia_id, Long plan_id, Long forma_id, Date fechaContrato) {
        this.alumno_id = alumno_id;
        this.titular_id = titular_id;
        this.asesor_id = asesor_id;
        this.estrategia_id = estrategia_id;
        this.plan_id = plan_id;
        this.forma_id = forma_id;
        this.fechaContrato = fechaContrato;
    }
}
