package com.darkcode.apirest.models.entity.petitions;

public class Employee {

    private Long id;
    private Long persona_id;
    private float salario;

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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Employee(Long id, Long persona_id, float salario) {
        this.id = id;
        this.persona_id = persona_id;
        this.salario = salario;
    }

    public Employee() {
    }
}

