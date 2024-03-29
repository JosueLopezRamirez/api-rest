package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.ICobradorDao;
import com.darkcode.apirest.models.DAO.IEmpleadoDao;
import com.darkcode.apirest.models.entity.Cobrador;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.services.services.ICobradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CobradorServiceImplement implements ICobradorService {

    @Autowired
    private ICobradorDao cobradorDao;

    @Autowired
    private IEmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cobrador> findAll() {
        return (List<Cobrador>) cobradorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cobrador findById(Long id) {
        return cobradorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cobrador save(Cobrador cobrador) {
        return cobradorDao.save(cobrador);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cobradorDao.deleteById(id);
    }

    @Override
    @Transactional
    public Empleado findEmployeeById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }
}
