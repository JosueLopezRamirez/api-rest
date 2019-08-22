package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.DTO.RecordProduccion;
import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.models.entity.composite.ContratoId;
import com.darkcode.apirest.services.services.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ContratoRestController {

    @Autowired
    private IContratoService contratoService;

    @GetMapping("/contratos")
    public List<Contrato> select(){
        return contratoService.findAll();
    }

    @GetMapping("/contratos/{id}")
    public ResponseEntity<?> show(@PathVariable ContratoId id){
    	Contrato contrato = null;
    	Map<String, Object> response = new HashMap<>();
    	
    	try {
    		contrato = contratoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}

    	if(contrato == null) {
    		response.put("mensaje", "El contrato con el ID".concat(id.toString().concat(" no existe en la base de datos~!")));
    		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
    }

    @GetMapping("/contratos-record")
    public List<RecordProduccion> recordProduccion(){
        return contratoService.recordProduccion();
    }

    @PostMapping("/contratos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contrato create(@RequestBody ContratoDTO contratoDTO){
        Contrato contrato = new Contrato();
        //Asignando la llave compuesta a nuestra entidad proveniente de una trama sin formato POJO-JPQL
        contrato.setContratoId(
                new ContratoId(
                        contratoService.findAsesorById(contratoDTO.getAsesor_id()),
                        contratoService.findTitularById(contratoDTO.getTitular_id()),
                        contratoService.findAlumnoById(contratoDTO.getAlumno_id())
                )
        );
        contrato.setEstrategia(contratoService.findEstrategiaById(contratoDTO.getEstrategia_id()));
        contrato.setPlanPago(contratoService.findPlanById(contratoDTO.getPlan_id()));
        contrato.setEstrategia(contratoService.findEstrategiaById(contratoDTO.getEstrategia_id()));
        contrato.setFormaPago(contratoService.findFormaById(contratoDTO.getForma_id()));
        contrato.setFechaContrato(contratoDTO.getFechaContrato());
        //Devolviendo un objeto completo
        return contratoService.save(contrato);
    }

    @DeleteMapping("/contratos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody ContratoId id){
        contratoService.delete(id);
    }
}