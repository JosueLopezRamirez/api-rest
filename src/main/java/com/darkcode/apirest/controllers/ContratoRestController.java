package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.models.entity.composite.ContratoId;
import com.darkcode.apirest.services.services.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/contratos/dto")
    public List<ContratoDTO> selectDto(){
        return contratoService.findAllContratoDto();
    }

    @GetMapping("/contratos/dto/{id}")
    public ContratoDTO showDto(@PathVariable Long id){
        return contratoService.findContratoDtoById(id);
    }

    @GetMapping("/contratos/{id}")
    public Contrato show(@PathVariable Long id){
        return contratoService.findById(id);
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

    //@PutMapping("/contratos")

    @DeleteMapping("/contratos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        contratoService.delete(id);
    }
}