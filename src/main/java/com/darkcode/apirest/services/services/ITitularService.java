package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Titular;

import java.util.List;

public interface ITitularService {

    public List<Titular> findAll();

    public Titular findById(Long id);

    public Titular save(Titular titular);

    public void delete(Long id);

    public Cliente findClientById(Long id);
}
