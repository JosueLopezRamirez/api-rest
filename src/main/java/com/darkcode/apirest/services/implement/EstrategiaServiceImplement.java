package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IEstrategiaDao;
import com.darkcode.apirest.models.entity.Estrategia;
import com.darkcode.apirest.services.services.IEstrategiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstrategiaServiceImplement implements IEstrategiaService {

    @Autowired
    private IEstrategiaDao estrategiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estrategia> findAll() {
        return (List<Estrategia>) estrategiaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estrategia findById(Long id) {
        return estrategiaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Estrategia save(Estrategia estrategia) {
        return estrategiaDao.save(estrategia);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estrategiaDao.deleteById(id);
    }
}
