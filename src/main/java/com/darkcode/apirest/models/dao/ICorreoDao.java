package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.Correo;
import org.springframework.data.repository.CrudRepository;

public interface ICorreoDao extends CrudRepository<Correo,Long> {
}
