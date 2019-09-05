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

    @Query(value = "{CALL SP_MENSUALIDAD_CANCELADOS(:fecha_inicio,:fecha_fin)}",nativeQuery = true)
    public List<Object[]> SP_MENSUALIDAD_CANCELADOS(Date fecha_inicio,Date fecha_fin);

    @Query(value = "{CALL SP_CAMBIAR_ESTADO_MENSUALIDAD(:estado,:id)}",nativeQuery = true)
    public List<Object[]> SP_CAMBIAR_ESTADO_MENSUALIDAD(boolean estado,Long id);

    @Query(value = "{CALL SP_MENSUALIDAD_CANCELADOS_TOTALES()}",nativeQuery = true)
    public List<Object[]> SP_MENSUALIDAD_CANCELADOS_TOTALES();

    @Query(value = "{CALL SP_ESTADO_CUENTA(:id)}",nativeQuery = true)
    public List<Object[]> SP_ESTADO_CUENTA(String id);
}
