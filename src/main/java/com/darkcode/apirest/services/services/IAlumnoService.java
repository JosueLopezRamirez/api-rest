package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno findById(String id);

    public Alumno save(Alumno alumno);

    public void delete(String id);

    public Cliente findClientById(Long id);
}
