package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Estrategia;
import org.springframework.data.repository.CrudRepository;

public interface IEstrategiaDao extends CrudRepository<Estrategia,Long> {
}
