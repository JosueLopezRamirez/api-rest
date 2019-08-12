package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.models.entity.composite.ContratoId;
import org.springframework.data.repository.CrudRepository;

public interface IContratoDao extends CrudRepository<Contrato, ContratoId> {

}
