package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Mensualidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IMensualidadDao extends CrudRepository<Mensualidad,Long> {

    @Query(value = "{CALL SP_MENSUALIDAD_PENDIENTES(:fecha_inicio,:fecha_fin,:fecha_actual)}",nativeQuery = true)
    public List<Object[]> SP_MENSUALIDAD_PENDIENTES(Date fecha_inicio, Date fecha_fin, Date fecha_actual);

    @Query(value = "{CALL SP_MENSUALIDAD_ATRASADOS()}",nativeQuery = true)
    public List<Object[]> SP_MENSUALIDAD_ATRASADOS();
}
