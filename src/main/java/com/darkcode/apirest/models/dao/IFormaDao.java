package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.FormaPago;
import org.springframework.data.repository.CrudRepository;

public interface IFormaDao extends CrudRepository<FormaPago,Long> {
}
