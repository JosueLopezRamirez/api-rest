package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.PlanPago;
import com.darkcode.apirest.services.services.IPlanPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class PlanPagoRestController {
	
	@Autowired
	private IPlanPagoService planService;
	
	@GetMapping("/planes")
	public List<PlanPago> select(){
		return planService.findAll();
	}

	@GetMapping("/planes/{id}")
	public PlanPago show(@PathVariable Long id){ return planService.findById(id); }

	@PostMapping("/planes")
	@ResponseStatus(HttpStatus.CREATED)
	public PlanPago create(@RequestBody PlanPago planPago){ return planService.save(planPago); }

	@PutMapping("/planes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PlanPago update(@RequestBody PlanPago planPago, @PathVariable Long id){
		PlanPago planActual = planService.findById(id);
		planActual.setInscripcion(planPago.getInscripcion());
		planActual.setCostoMensual(planPago.getCostoMensual());
		planActual.setValorTotal(planPago.getValorTotal());
		return planService.save(planActual);
	}

	@DeleteMapping("/planes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		planService.delete(id);
	}
}
