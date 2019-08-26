package com.darkcode.apirest.controllers;


import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.MensualidadDTO;
import com.darkcode.apirest.models.entity.Mensualidad;
import com.darkcode.apirest.services.services.IMensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class MensualidadRestController {

    @Autowired
    private IMensualidadService mensualidadService;

    @GetMapping("/mensualidades")
    public List<MensualidadDTO> select(){
        return mensualidadService.findAll();
    }

    @GetMapping("/mensualidades/{id}")
    public MensualidadDTO show(@PathVariable Long id){
        return mensualidadService.findById(id);
    }

    @PostMapping("/mensualidades")
    @ResponseStatus(HttpStatus.CREATED)
    public MensualidadDTO create(@RequestBody Mensualidad mensualidad){
        return mensualidadService.save(mensualidad);
    }

    @DeleteMapping("/mensualidades")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Long id){
        mensualidadService.delete(id);
    }
}