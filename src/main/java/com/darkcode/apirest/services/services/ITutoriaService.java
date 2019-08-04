package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Tutoria;

import java.util.List;

public interface ITutoriaService {

    public List<Tutoria> findAll();

    public Tutoria findById(Long id);

    public Tutoria save(Tutoria tutoria);

    public void delete(Long id);
}
