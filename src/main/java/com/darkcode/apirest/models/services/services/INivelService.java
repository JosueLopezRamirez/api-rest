package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Nivel;

import java.util.List;

public interface INivelService {

    public List<Nivel> findAll();

    public Nivel findById(Long id);

    public Nivel save(Nivel nivel);

    public void delete(Long id);
}
