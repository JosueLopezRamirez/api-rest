package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno findById(Long id);

    public Alumno save(Alumno alumno);

    public void delete(Long id);

    public Cliente findClientById(Long id);
}
