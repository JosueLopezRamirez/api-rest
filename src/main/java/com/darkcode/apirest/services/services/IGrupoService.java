package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.models.entity.Organizacion;

import java.util.List;

public interface IGrupoService {

    public List<Grupo> findAll();

    public Grupo findById(Long id);

    public Grupo save(Grupo grupo);

    public void delete(Long id);

    public Organizacion findOrganizationById(Long id);
}
