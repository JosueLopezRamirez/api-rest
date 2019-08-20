package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.AsesorNames;
import com.darkcode.apirest.models.DAO.IAsesorDao;
import com.darkcode.apirest.models.DAO.IEmpleadoDao;
import com.darkcode.apirest.models.DAO.IGrupoDao;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.services.services.IAsesorService;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    @Transactional
    public Grupo findGroupById(Long id) { return grupoDao.findById(id).orElse(null); }

	@Override
	@Transactional
	public List<AsesorNames> buscarAsesorNombreApellido() {
		List<Object[]> lista = asesorDao.GET_ASESORES_DATOS_PERSONALES();
        List<AsesorNames> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> {
            listaDevuelta.add(new AsesorNames((BigInteger) item[0],(String)item[1],(String)item[2]));
        });
		return listaDevuelta;
	}
}
