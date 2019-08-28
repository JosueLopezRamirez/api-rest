package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Contrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

public interface IContratoDao extends CrudRepository<Contrato, Long> {

    @Query(value = "{call SP_RECORD_PRODUCCION}",nativeQuery = true)
    public List<Object[]> SP_RECORD_PRODUCCION();

}
