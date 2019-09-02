package com.darkcode.apirest.DTO;

public class ClienteDTO {

    private Long id;
    private Long persona_id;
    private String direccion;
    private String cedula;
    private boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Long persona_id) {
        this.persona_id = persona_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ClienteDTO() { }

    public ClienteDTO(Long id, Long persona_id, String direccion, String cedula, boolean estado) {
        this.id = id;
        this.persona_id = persona_id;
        this.direccion = direccion;
        this.cedula = cedula;
        this.estado = estado;
    }
}
