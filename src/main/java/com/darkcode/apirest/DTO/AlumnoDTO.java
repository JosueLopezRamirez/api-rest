package com.darkcode.apirest.DTO;

public class AlumnoDTO {

    private String id;
    private Long cliente_id;
    private boolean activo;
    private short nivel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    public AlumnoDTO() {
    }

    public AlumnoDTO(String id, Long cliente_id, boolean activo, short nivel) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.activo = activo;
        this.nivel = nivel;
    }
}
