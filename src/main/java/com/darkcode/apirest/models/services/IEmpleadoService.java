package com.darkcode.apirest.models.services;

import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Persona;

import java.util.List;

public interface IEmpleadoService {

    public Empleado findById(Long id);

    public Empleado save(Empleado empleado);

    public void delete(Long id);

    public List<Empleado> findAll();

    public Persona findPersonById(Long id);
}
