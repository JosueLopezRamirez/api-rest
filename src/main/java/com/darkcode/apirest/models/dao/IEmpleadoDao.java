package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {

}
