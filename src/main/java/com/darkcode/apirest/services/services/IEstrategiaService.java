package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Estrategia;

import java.util.List;

public interface IEstrategiaService {

    public List<Estrategia> findAll();

    public Estrategia findById(Long id);

    public Estrategia save(Estrategia estrategia);

    public void delete(Long id);
}
