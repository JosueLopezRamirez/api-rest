package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.ExamenUbicacion;
import org.springframework.data.repository.CrudRepository;

public interface IExamenDao extends CrudRepository<ExamenUbicacion,Long> {
}
