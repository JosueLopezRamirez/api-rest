package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
