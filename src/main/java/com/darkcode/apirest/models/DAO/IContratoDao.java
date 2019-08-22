package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.models.entity.composite.ContratoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IContratoDao extends CrudRepository<Contrato, ContratoId> {

    @Query(value = "{call SP_RECORD_PRODUCCION}",nativeQuery = true)
    public List<Object[]> SP_RECORD_PRODUCCION();
}
