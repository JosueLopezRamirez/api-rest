package com.darkcode.apirest.controllers;


import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Estrategia;
import com.darkcode.apirest.services.services.IEstrategiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class EstrategiaRestController {

    @Autowired
    private IEstrategiaService estrategiaService;

    @GetMapping("/estrategias")
    public List<Estrategia> select(){
        return estrategiaService.findAll();
    }

    @GetMapping("/estrategias/{id}")
    public Estrategia show(@PathVariable Long id){ return estrategiaService.findById(id); }

    @PostMapping("/estrategias")
    @ResponseStatus(HttpStatus.CREATED)
    public Estrategia create(@RequestBody Estrategia estrategia){ return estrategiaService.save(estrategia); }

    @PutMapping("/estrategias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estrategia update(@RequestBody Estrategia estrategia, @PathVariable Long id){
        Estrategia estrategiaActual = estrategiaService.findById(id);
        estrategiaActual.setDescripcion(estrategia.getDescripcion());
        return estrategiaService.save(estrategiaActual);
    }

    @DeleteMapping("/estrategias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        estrategiaService.delete(id);
    }
}
