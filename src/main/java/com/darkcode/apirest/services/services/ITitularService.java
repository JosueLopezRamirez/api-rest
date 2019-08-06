package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Titular;

import java.util.List;

public interface ITitularService {

    public List<Titular> findAll();

    public Titular findById(String id);

    public Titular save(Titular titular);

    public void delete(String id);

    public Cliente findClientById(Long id);
}
