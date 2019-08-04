package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.dao.IEmpleadoDao;
import com.darkcode.apirest.models.dao.IPersonaDao;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.services.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImplement implements IEmpleadoService {

    @Autowired
    private IEmpleadoDao empleadoDao;

    @Autowired
    private IPersonaDao personaDao;

    //Obtener todos los empleados
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    //Obtener empleado por id
    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    //Insertar nuevo empleado
    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    //Eliminar un empleado
    @Override
    @Transactional
    public void delete(Long id) {
        empleadoDao.deleteById(id);
    }

    //Buscar una persona por id para asignarle luego el rol de empleado
    @Override
    @Transactional(readOnly = true)
    public Persona findPersonById(Long id) {
        return personaDao.findById(id).orElse(null);
    }
}
