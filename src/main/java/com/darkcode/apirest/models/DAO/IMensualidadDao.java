package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Mensualidad;
import org.springframework.data.repository.CrudRepository;

public interface IMensualidadDao extends CrudRepository<Mensualidad,Long> {
}
