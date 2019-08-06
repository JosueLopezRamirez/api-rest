package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IAlumnoDao;
import com.darkcode.apirest.models.DAO.IExamenDao;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.ExamenUbicacion;
import com.darkcode.apirest.services.services.IAlumnoService;
import com.darkcode.apirest.services.services.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenServiceImplement implements IExamenService {

    @Autowired
    private IExamenDao examenDao;

    @Autowired
    private IAlumnoDao alumnoDao;

    @Override
    @Transactional(readOnly = true)
    public List<ExamenUbicacion> findAll() {
        return (List<ExamenUbicacion>) examenDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ExamenUbicacion findById(Long id) {
        return examenDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ExamenUbicacion save(ExamenUbicacion examen) {
        return examenDao.save(examen);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        examenDao.deleteById(id);
    }

    @Override
    @Transactional
    public Alumno findAlumnoById(Long id) {
        return alumnoDao.findById(id).orElse(null);
    }
}
