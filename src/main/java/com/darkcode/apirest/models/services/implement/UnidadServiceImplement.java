package com.darkcode.apirest.models.services.implement;

import com.darkcode.apirest.models.dao.IUnidadDao;
import com.darkcode.apirest.models.entity.Unidad;
import com.darkcode.apirest.models.services.services.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnidadServiceImplement implements IUnidadService {

    @Autowired
    private IUnidadDao unidadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Unidad> findAll() {
        return (List<Unidad>) unidadDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Unidad findById(Long id) {
        return unidadDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Unidad save(Unidad unidad) {
        return unidadDao.save(unidad);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        unidadDao.deleteById(id);
    }
}
