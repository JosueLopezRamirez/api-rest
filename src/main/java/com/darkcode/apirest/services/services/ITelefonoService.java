package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Telefono;

import java.util.List;

public interface ITelefonoService {

    public List<Telefono> findAll();

    public Telefono findById(Long id);

    public Telefono save(Telefono telefono);

    public void delete(Long id);

    public Cliente findClienteById(Long id);
}
