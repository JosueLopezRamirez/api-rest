package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.dao.IAsesorDao;
import com.darkcode.apirest.models.dao.IEmpleadoDao;
import com.darkcode.apirest.models.dao.IGrupoDao;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.services.services.IAsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsesorServiceImplement implements IAsesorService {

    @Autowired
    private IAsesorDao asesorDao;

    @Autowired
    private IEmpleadoDao empleadoDao;

    @Autowired
    private IGrupoDao grupoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asesor> findAll() {
        return (List<Asesor>) asesorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Asesor findById(Long id) {
        return asesorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Asesor save(Asesor asesor) {
        return asesorDao.save(asesor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        asesorDao.deleteById(id);
    }

    @Override
    @Transactional
    public Empleado findEmployeeById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public Grupo findGroupById(Long id) { return grupoDao.findById(id).orElse(null); }
}
