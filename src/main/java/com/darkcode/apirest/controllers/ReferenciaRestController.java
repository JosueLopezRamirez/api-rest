package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Referencia;
import com.darkcode.apirest.services.services.IReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ReferenciaRestController {

    @Autowired
    private IReferenciaService referenciaService;

    @GetMapping("/referencias")
    public List<Referencia> select(){
        return referenciaService.findAll();
    }

    @GetMapping("/referencias/{id}")
    public Referencia show(@PathVariable Long id){
        return referenciaService.findById(id);
    }

    @PostMapping("/referencias/{persona_id}/{titular_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Referencia create(@RequestBody Referencia referencia, @PathVariable Long persona_id,@PathVariable String titular_id){
        referencia.setPersona(referenciaService.findPersonaById(persona_id));
        referencia.setTitular(referenciaService.findTitularById(titular_id));
        return referenciaService.save(referencia);
    }

    @PostMapping("/referencias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Referencia update(@RequestBody Referencia referencia,@PathVariable Long id){
        Referencia referenciaActual = referenciaService.findById(id);
        referenciaActual.setTelefono(referencia.getTelefono());
        return referenciaService.save(referenciaActual);
    }

    @DeleteMapping("/referencias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        referenciaService.delete(id);
    }
}
