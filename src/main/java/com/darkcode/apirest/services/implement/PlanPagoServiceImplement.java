package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.dao.IPlanPagoDao;
import com.darkcode.apirest.models.entity.PlanPago;
import com.darkcode.apirest.services.services.IPlanPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanPagoServiceImplement implements IPlanPagoService {

	@Autowired
	private IPlanPagoDao planDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PlanPago> findAll() {
		return (List<PlanPago>)planDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PlanPago findById(Long id) { return planDao.findById(id).orElse(null); }

	@Override
	@Transactional
	public PlanPago save(PlanPago plan) {
		return planDao.save(plan);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		planDao.deleteById(id);
	}


}
