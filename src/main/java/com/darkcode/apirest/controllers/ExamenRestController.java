package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.ExamenUbicacion;
import com.darkcode.apirest.services.services.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ExamenRestController {

    @Autowired
    private IExamenService examenService;

    @GetMapping("/examenes")
    public List<ExamenUbicacion> select(){ return examenService.findAll(); }

    @GetMapping("/examenes/{id}")
    public ExamenUbicacion show(@PathVariable Long id){ return examenService.findById(id); }

    @PostMapping("/examenes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ExamenUbicacion create(@RequestBody ExamenUbicacion examen,@PathVariable String id){
        examen.setAlumno(examenService.findAlumnoById(id));
        return examenService.save(examen);
    }

    @PutMapping("/examenes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ExamenUbicacion update(@RequestBody ExamenUbicacion examen, @PathVariable Long id){
        ExamenUbicacion examenActual = examenService.findById(id);
        examenActual.setNivelExamen(examen.getNivelExamen());
        return examenService.save(examenActual);
    }

    @DeleteMapping("/examen/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ examenService.delete(id); }
}
