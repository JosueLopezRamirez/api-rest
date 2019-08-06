package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.INivelDao;
import com.darkcode.apirest.models.entity.Nivel;
import com.darkcode.apirest.services.services.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NivelServiceImplement implements INivelService {

    @Autowired
    private INivelDao nivelDao;

    @Override
    @Transactional(readOnly = true)
    public List<Nivel> findAll() {
        return (List<Nivel>) nivelDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Nivel findById(Long id) {
        return nivelDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Nivel save(Nivel nivel) {
        return nivelDao.save(nivel);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        nivelDao.deleteById(id);
    }
}
