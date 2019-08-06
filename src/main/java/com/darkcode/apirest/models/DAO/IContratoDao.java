package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Contrato;
import org.springframework.data.repository.CrudRepository;

public interface IContratoDao extends CrudRepository<Contrato,Long> {
}
