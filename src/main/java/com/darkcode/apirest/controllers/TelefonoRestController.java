package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Telefono;
import com.darkcode.apirest.services.services.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TelefonoRestController {

    @Autowired
    private ITelefonoService telefonoService;

    @GetMapping("/telefonos")
    public List<Telefono> select(){ return telefonoService.findAll(); }

    @GetMapping("/telefonos/{id}")
    public Telefono show(@PathVariable Long id){ return telefonoService.findById(id); }

    @PostMapping("/telefonos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Telefono create(@RequestBody Telefono telefono,@PathVariable Long id){
        telefono.setCliente(telefonoService.findClienteById(id));
        return telefonoService.save(telefono);
    }

    @PutMapping("/telefonos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Telefono update(@RequestBody Telefono telefono, @PathVariable Long id){
        Telefono telefonoActual = telefonoService.findById(id);
        telefonoActual.setTelefono(telefono.getTelefono());
        return telefonoService.save(telefonoActual);
    }

    @DeleteMapping("/telefonos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ telefonoService.delete(id); }
}