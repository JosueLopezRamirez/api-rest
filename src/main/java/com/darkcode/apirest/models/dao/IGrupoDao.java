package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.Grupo;
import org.springframework.data.repository.CrudRepository;

public interface IGrupoDao extends CrudRepository<Grupo,Long> {
}
