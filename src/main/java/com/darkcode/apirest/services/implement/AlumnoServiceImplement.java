package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.DatosAlumnos;
import com.darkcode.apirest.models.DAO.IAlumnoDao;
import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.services.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Alumno findById(String id) { return alumnoDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) { return alumnoDao.save(alumno); }

    @Override
    @Transactional
    public void delete(String id) { alumnoDao.deleteById(id); }

    @Override
    @Transactional
    public List<DatosAlumnos> SP_GET_DATOS_ALUMNOS() {
        List<Object[]> lista = alumnoDao.SP_GET_DATOS_ALUMNOS();
        List<DatosAlumnos> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> {
            listaDevuelta.add(
                    new DatosAlumnos(
                            (String) item[0], (BigInteger) item[1],
                            (BigInteger) item[2], (String) item[3],
                            (String) item[4], (String) item[5],
                            (Short) item[6], (Boolean) item[7],
                            (String) item[8], (String) item[9]
                    )
            );
        });

        return listaDevuelta;
    }

    @Override
    @Transactional
    public Cliente findClientById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
}
