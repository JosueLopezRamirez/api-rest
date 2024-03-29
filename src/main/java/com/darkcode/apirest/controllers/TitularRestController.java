package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.DatosTitular;
import com.darkcode.apirest.DTO.NombreTitular;
import com.darkcode.apirest.models.entity.Titular;
import com.darkcode.apirest.services.services.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TitularRestController {

    @Autowired
    private ITitularService titularService;

    @GetMapping("/titulares")
    private List<Titular> select(){ return titularService.findAll(); }

    @GetMapping("/titulares/{id}")
    public Titular show(@PathVariable String id){ return titularService.findById(id); }

    @GetMapping("/titulares-datos")
    public List<DatosTitular> datosTitulares(){
        return titularService.SP_GET_DATOS_TITULARES();
    }

    @GetMapping("/titulares-nombres")
    public List<NombreTitular> nombreTitulares(){
        return titularService.SP_NOMBRE_COMPLETO_TITULAR();
    }

    @PostMapping("/titulares/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Titular create(@RequestBody Titular titular, @PathVariable Long id){
        titular.setCliente(titularService.findClientById(id));
        return titularService.save(titular);
    }

    @PutMapping("/titulares/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Titular update(@RequestBody Titular titular,@PathVariable String id){
        Titular titularActual = titularService.findById(id);
        titularActual.setNombreTrabajo(titular.getNombreTrabajo());
        titularActual.setDireccionTrabajo(titular.getDireccionTrabajo());
        titularActual.setTelefonoTrabajo(titular.getTelefonoTrabajo());
        titularActual.setSalario(titular.getSalario());
        return titularService.save(titularActual);
    }

    @DeleteMapping("/titulares/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){ titularService.delete(id); }
}