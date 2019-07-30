package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Organizacion;

import java.util.List;

public interface IOrganizacionService {

    public List<Organizacion> findAll();

    public Organizacion findById(Long id);

    public Organizacion save(Organizacion organizacion);

    public void delete(Long id);
}
