package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IAlumnoDao;
import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.services.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImplement implements IAlumnoService {

    @Autowired
    private IAlumnoDao alumnoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly =  true)
    public List<Alumno> findAll() { return (List<Alumno>) alumnoDao.findAll(); }

    @Override
    @Transactional(readOnly =  true)
    public Alumno findById(Long id) { return alumnoDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) { return alumnoDao.save(alumno); }

    @Override
    @Transactional
    public void delete(Long id) { alumnoDao.deleteById(id); }

    @Override
    @Transactional
    public Cliente findClientById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
}
