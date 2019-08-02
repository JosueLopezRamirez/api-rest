package com.darkcode.apirest.models.services.services;

import com.darkcode.apirest.models.entity.Tutor;

import java.util.List;

public interface ITutorService {

    public List<Tutor> findAll();

    public Tutor findById(Long id);

    public Tutor save(Tutor tutor);

    public void delete(Long id);
}
