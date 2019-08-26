package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.DatosAlumnos;
import com.darkcode.apirest.DTO.DatosGreen;
import com.darkcode.apirest.DTO.GreenHistorial;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();

    public Alumno findById(String id);

    public Alumno save(Alumno alumno);

    public void delete(String id);

    public List<DatosAlumnos> SP_GET_DATOS_ALUMNOS();

    public List<GreenHistorial> SP_GET_HISTORIAL_ACADEMICO(String alumno_id);
    
    public List<DatosGreen> SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(String nombre);
    
    public int ALUMNO_NOMBRE_COMPLETO_EXISTE(String nombre);
    
    public Cliente findClientById(Long id);
}
