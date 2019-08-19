package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.AsesorNames;
import com.darkcode.apirest.models.DAO.IAsesorDao;
import com.darkcode.apirest.models.DAO.IEmpleadoDao;
import com.darkcode.apirest.models.DAO.IGrupoDao;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Grupo;
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
    
    private EntityManagerFactory emf;
    private EntityManager em;
    @Before(value = "value")
    public void init() {
    	emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }
    
    @After(value = "value")
    public void close() {
    	emf.close();
    }
    
    
    
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
//		return asesorDao.GET_ASESORES_DATOS_PERSONALES();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Session session = em.unwrap(Session.class);
		ProcedureCall  call = session.createStoredProcedureCall("GET_ASESORES_DATOS_PERSONALES");
		Output output = call.getOutputs().getCurrent();
		List<AsesorNames> lista = ((ResultSetOutput) output).getResultList();
		return lista;
	}
}
