package com.darkcode.apirest.models.controllers;

import java.util.List;

import com.darkcode.apirest.models.entity.PlanPago;
import com.darkcode.apirest.models.services.IPlanPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PlanPagosRestController {
	
	@Autowired
	private IPlanPagoService planService;
	
	@GetMapping("/plan")
	public List<PlanPago> index(){
		return planService.findAll();
	}
}
