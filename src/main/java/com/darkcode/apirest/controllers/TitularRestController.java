package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Titular;
import com.darkcode.apirest.services.services.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TitularRestController {

    @Autowired
    private ITitularService titularService;

    @GetMapping("/titular")
    private List<Titular> select(){ return titularService.findAll(); }

    @GetMapping("/titular/{id}")
    public Titular show(@PathVariable Long id){ return titularService.findById(id); }

    @PostMapping("/titular/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Titular create(@RequestBody Titular titular, @PathVariable Long id){
        titular.setCliente(titularService.findClientById(id));
        return titularService.save(titular);
    }

    @PutMapping("/titular/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Titular update(@RequestBody Titular titular,@PathVariable Long id){
        Titular titularActual = titularService.findById(id);
        titularActual.setNombreTrabajo(titular.getNombreTrabajo());
        titularActual.setDireccionTrabajo(titular.getDireccionTrabajo());
        titularActual.setTelefonoTrabajo(titular.getTelefonoTrabajo());
        titularActual.setSalario(titular.getSalario());
        return titularService.save(titularActual);
    }

    @DeleteMapping("/titular/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ titularService.delete(id); }
}