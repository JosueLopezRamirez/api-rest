package com.darkcode.apirest.models.services.implement;

import java.util.List;

import com.darkcode.apirest.models.dao.IPlanPagoDao;
import com.darkcode.apirest.models.entity.PlanPago;
import com.darkcode.apirest.models.services.services.IPlanPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanPagoServiceImplement implements IPlanPagoService {

	@Autowired
	private IPlanPagoDao planDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PlanPago> findAll() {
		return (List<PlanPago>)planDao.findAll();
	}

}
