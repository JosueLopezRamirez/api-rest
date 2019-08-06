package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.models.entity.Referencia;
import com.darkcode.apirest.models.entity.Titular;

import java.util.List;

public interface IReferenciaService {

    public List<Referencia> findAll();

    public Referencia findById(Long id);

    public Referencia save(Referencia referencia);

    public void delete(Long id);

    public Persona findPersonaById(Long id);

    public Titular findTitularById(String id);
}
