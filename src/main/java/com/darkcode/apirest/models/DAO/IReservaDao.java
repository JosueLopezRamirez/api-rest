package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.ReservaTutoria;
import com.darkcode.apirest.models.entity.composite.ReservaId;
import org.springframework.data.repository.CrudRepository;

public interface IReservaDao extends CrudRepository<ReservaTutoria, ReservaId> {
}
