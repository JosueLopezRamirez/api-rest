package com.darkcode.apirest.models.services;

import com.darkcode.apirest.models.dao.IPersonaDao;
import com.darkcode.apirest.models.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImplements implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaDao.deleteById(id);
    }
}
