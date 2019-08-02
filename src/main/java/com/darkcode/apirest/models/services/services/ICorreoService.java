package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Correo;

import java.util.List;

public interface ICorreoService {

    public List<Correo> findAll();

    public Correo findById(Long id);

    public Correo save(Correo correo);

    public void delete(Long id);

    public Cliente findClienteById(Long id);
}
