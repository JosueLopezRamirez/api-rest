package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.EstadoCliente;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Persona;

import java.math.BigInteger;
import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public Persona findPersonById(Long id);

    public List<EstadoCliente> SP_CAMBIAR_ESTADO_CLIENTE(boolean estado, BigInteger id);
}
