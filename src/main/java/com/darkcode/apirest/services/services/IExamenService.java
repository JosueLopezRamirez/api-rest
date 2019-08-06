package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.ExamenUbicacion;

import java.util.List;

public interface IExamenService {

    public List<ExamenUbicacion> findAll();

    public ExamenUbicacion findById(Long id);

    public ExamenUbicacion save(ExamenUbicacion examen);

    public void delete(Long id);

    public Alumno findAlumnoById(Long id);
}
