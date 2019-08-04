package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Unidad;
import com.darkcode.apirest.services.services.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class UnidadRestController {

    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/unidad")
    public List<Unidad> select(){
        return unidadService.findAll();
    }

    @GetMapping("/unidad/{id}")
    public Unidad show(@PathVariable Long id){ return unidadService.findById(id); }

    @PostMapping("/unidad")
    @ResponseStatus(HttpStatus.CREATED)
    public Unidad create(@RequestBody Unidad unidad){ return unidadService.save(unidad); }

    @PutMapping("/unidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Unidad update(@RequestBody Unidad unidad, @PathVariable Long id){
        Unidad unidadActual = unidadService.findById(id);
        unidadActual.setDescripcion(unidad.getDescripcion());
        return unidadService.save(unidadActual);
    }

    @DeleteMapping("/unidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        unidadService.delete(id);
    }
}
