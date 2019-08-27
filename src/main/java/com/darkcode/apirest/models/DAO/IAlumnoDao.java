package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Alumno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoDao extends CrudRepository<Alumno,String> {

    @Query(value = "{CALL SP_GET_DATOS_ALUMNOS}",nativeQuery = true)
    public List<Object[]> SP_GET_DATOS_ALUMNOS();
    
    @Query(value = "{CALL SP_GET_HISTORIAL_ACADEMICO(:alumno_id)}",nativeQuery = true)
    public List<Object[]> SP_GET_HISTORIAL_ACADEMICO(String alumno_id);
    
    @Query(value = "{CALL SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(:nombre)}",nativeQuery = true)
    public Object[] SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(String nombre);
    
    @Query(value = "SELECT ALUMNO_NOMBRE_COMPLETO_EXISTE(:nombre)",nativeQuery = true)
    public int ALUMNO_NOMBRE_COMPLETO_EXISTE(String nombre);

    @Query(value = "{CALL SP_LISTA_ALUMNOS_RESERVA(:fecha,:hora)}",nativeQuery = true)
    public List<Object[]> SP_LISTA_ALUMNOS_RESERVA(String fecha,String hora);
}
