package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.Organizacion;
import org.springframework.data.repository.CrudRepository;

public interface IOrganizacionDao extends CrudRepository<Organizacion,Long> {
}
