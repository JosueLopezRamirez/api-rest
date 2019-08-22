package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoDao extends CrudRepository<Alumno,String> {

    @Query(value = "{CALL SP_GET_DATOS_ALUMNOS}",nativeQuery = true)
    public List<Object[]> SP_GET_DATOS_ALUMNOS();
}
