package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Nivel;
import com.darkcode.apirest.services.services.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class NivelRestController {

    @Autowired
    private INivelService nivelService;

    @GetMapping("/nivel")
    public List<Nivel> select(){
        return nivelService.findAll();
    }

    @GetMapping("/nivel/{id}")
    public Nivel show(@PathVariable Long id){ return nivelService.findById(id); }

    @PostMapping("/nivel")
    @ResponseStatus(HttpStatus.CREATED)
    public Nivel create(@RequestBody Nivel nivel){ return nivelService.save(nivel); }

    @PutMapping("/nivel/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Nivel update(@RequestBody Nivel nivel, @PathVariable Long id){
        Nivel nivelActual = nivelService.findById(id);
        nivelActual.setDescripcion(nivel.getDescripcion());
        return nivelService.save(nivelActual);
    }

    @DeleteMapping("/nivel/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        nivelService.delete(id);
    }
}
