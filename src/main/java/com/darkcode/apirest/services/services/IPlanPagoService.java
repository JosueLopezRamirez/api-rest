package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.PlanPago;

import java.util.List;

public interface IPlanPagoService {
	public List<PlanPago> findAll();

	public PlanPago findById(Long id);

	public PlanPago save(PlanPago plan);

	public void delete(Long id);
}
