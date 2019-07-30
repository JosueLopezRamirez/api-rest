package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Cobrador;
import com.darkcode.apirest.models.entity.Empleado;

import java.util.List;

public interface ICobradorService {

    public List<Cobrador> findAll();

    public Cobrador findById(Long id);

    public Cobrador save(Cobrador cobrador);

    public void delete(Long id);

    public Empleado findEmployeeById(Long id);
}
