package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Unidad;

import java.util.List;

public interface IUnidadService {

    public List<Unidad> findAll();

    public Unidad findById(Long id);

    public Unidad save(Unidad unidad);

    public void delete(Long id);
}
