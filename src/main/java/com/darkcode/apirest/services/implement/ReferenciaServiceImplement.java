package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IPersonaDao;
import com.darkcode.apirest.models.DAO.IReferenciaDao;
import com.darkcode.apirest.models.DAO.ITitularDao;
import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.models.entity.Referencia;
import com.darkcode.apirest.models.entity.Titular;
import com.darkcode.apirest.services.services.IReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReferenciaServiceImplement implements IReferenciaService {

    @Autowired
    private IReferenciaDao referenciaDao;

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private ITitularDao titularDao;

    @Override
    @Transactional(readOnly = true)
    public List<Referencia> findAll() {
        return (List<Referencia>) referenciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Referencia findById(Long id) {
        return referenciaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Referencia save(Referencia referencia) {
        return referenciaDao.save(referencia);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        referenciaDao.deleteById(id);
    }

    @Override
    @Transactional
    public Persona findPersonaById(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Titular findTitularById(String id) {
        return titularDao.findById(id).orElse(null);
    }
}
