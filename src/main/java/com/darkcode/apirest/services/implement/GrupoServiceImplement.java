package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IGrupoDao;
import com.darkcode.apirest.models.DAO.IOrganizacionDao;
import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.models.entity.Organizacion;
import com.darkcode.apirest.services.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrupoServiceImplement implements IGrupoService {

    @Autowired
    private IGrupoDao grupoDao;

    @Autowired
    private IOrganizacionDao organizacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Grupo> findAll() {
        return (List<Grupo>) grupoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Grupo findById(Long id) {
        return grupoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Grupo save(Grupo grupo) {
        return grupoDao.save(grupo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        grupoDao.deleteById(id);
    }

    @Override
    @Transactional
    public Organizacion findOrganizationById(Long id) {
        return organizacionDao.findById(id).orElse(null);
    }
}
