package com.darkcode.apirest.models.services.implement;

import com.darkcode.apirest.models.dao.IOrganizacionDao;
import com.darkcode.apirest.models.entity.Organizacion;
import com.darkcode.apirest.models.services.services.IOrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrganizacionServiceImplement implements IOrganizacionService {

    @Autowired
    private IOrganizacionDao organizacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Organizacion> findAll() {
        return (List<Organizacion>) organizacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Organizacion findById(Long id) {
        return organizacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Organizacion save(Organizacion organizacion) {
        return organizacionDao.save(organizacion);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        organizacionDao.deleteById(id);
    }
}
