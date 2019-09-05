package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Titular;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITitularDao extends CrudRepository<Titular,String> {

    @Query(value = "{CALL SP_GET_DATOS_TITULARES}",nativeQuery = true)
    public List<Object[]> SP_GET_DATOS_TITULARES();

    @Query(value = "{CALL SP_NOMBRE_COMPLETO_TITULAR}",nativeQuery = true)
    public List<Object[]> SP_NOMBRE_COMPLETO_TITULAR();

}
