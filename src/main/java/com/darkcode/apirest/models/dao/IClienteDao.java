package com.darkcode.apirest.models.dao;

import com.darkcode.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

}
