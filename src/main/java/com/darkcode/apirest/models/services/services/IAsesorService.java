package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Grupo;

import java.util.List;

public interface IAsesorService {

    public List<Asesor> findAll();

    public Asesor findById(Long id);

    public Asesor save(Asesor asesor);

    public void delete(Long id);

    public Empleado findEmployeeById(Long id);

    public Grupo findGroupById(Long id);
}
