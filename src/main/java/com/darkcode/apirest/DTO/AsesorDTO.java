package com.darkcode.apirest.DTO;

public class AsesorDTO {
    private Long id;
    private Long empleado_id;
    private Long grupo_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public Long getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Long grupo_id) {
        this.grupo_id = grupo_id;
    }
}
