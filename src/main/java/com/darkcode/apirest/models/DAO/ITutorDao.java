package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Tutor;
import org.springframework.data.repository.CrudRepository;

public interface ITutorDao extends CrudRepository<Tutor,Long> {
}
