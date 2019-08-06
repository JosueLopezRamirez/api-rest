package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoDao extends CrudRepository<Alumno,Long> {
}
