package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

    @Query(value = "{CALL SP_CAMBIAR_ESTADO_CLIENTE(:estado,:id)}",nativeQuery = true)
    public List<Object[]> SP_CAMBIAR_ESTADO_CLIENTE(boolean estado, BigInteger id);
}
