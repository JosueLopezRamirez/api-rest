package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Cobrador;
import com.darkcode.apirest.DTO.CobradorDTO;
import com.darkcode.apirest.services.services.ICobradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class CobradorRestController {

    @Autowired
    private ICobradorService cobradorService;

    @GetMapping("/cobradores")
    public List<Cobrador> select() {
        return cobradorService.findAll();
    }

    @GetMapping("/cobradores/{id}")
    public Cobrador show(@PathVariable Long id){
        return cobradorService.findById(id);
    }

    @PostMapping("/cobradores")
    @ResponseStatus(HttpStatus.CREATED)
    public Cobrador create(@RequestBody CobradorDTO cobradorDTO){
        Cobrador cobrador = new Cobrador();
        cobrador.setEmpleado(cobradorService.findEmployeeById(cobradorDTO.getEmpleado_id()));
        return cobradorService.save(cobrador);
    }

    @DeleteMapping("/cobradores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        cobradorService.delete(id);
    }
}

