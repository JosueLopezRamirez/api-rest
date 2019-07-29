package com.darkcode.apirest.models.services;

import com.darkcode.apirest.models.entity.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> findAll();

    public Persona findById(Long id);

    public Persona save(Persona persona);

    public void delete(Long id);
}
