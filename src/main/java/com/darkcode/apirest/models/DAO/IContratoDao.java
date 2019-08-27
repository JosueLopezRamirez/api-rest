package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.models.entity.composite.ContratoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IContratoDao extends CrudRepository<Contrato, ContratoId> {

    @Query(value = "{call SP_RECORD_PRODUCCION}",nativeQuery = true)
    public List<Object[]> SP_RECORD_PRODUCCION();

//    @Query(value = "{CALL INSERT_CONTRATO(:fecha,:titular_id,:alumno_id,:asesor,:estrategia,:forma,:plan)}", nativeQuery = true)
//    public Object[] INSERT_CONTRATO(String fecha, String titular_id,String alumno_id,Long asesor,Long estrategia,Long forma,Long plan);
}
