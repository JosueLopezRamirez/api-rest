package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Correo;
import com.darkcode.apirest.models.services.services.ICorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class CorreoRestController {

    @Autowired
    private ICorreoService correoService;

    @GetMapping("/correos")
    public List<Correo> select(){ return correoService.findAll(); }

    @GetMapping("/correos/{id}")
    public Correo show(@PathVariable Long id){ return correoService.findById(id); }

    @PostMapping("/correos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Correo create(@RequestBody Correo correo,@PathVariable Long id){
        correo.setCliente(correoService.findClienteById(id));
        return correoService.save(correo);
    }

    @PutMapping("/correos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Correo update(@RequestBody Correo correo, @PathVariable Long id){
        Correo correoActual = correoService.findById(id);
        correoActual.setCorreo(correo.getCorreo());
        return correoService.save(correoActual);
    }

    @DeleteMapping("/correos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ correoService.delete(id); }
}
