package com.darkcode.apirest.models.entity.petitions;

public class Group {
    private Long id;
    private String nombreGrupo;
    private Long organizacion_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Long getOrganizacion_id() {
        return organizacion_id;
    }

    public void setOrganizacion_id(Long organizacion_id) {
        this.organizacion_id = organizacion_id;
    }
}
