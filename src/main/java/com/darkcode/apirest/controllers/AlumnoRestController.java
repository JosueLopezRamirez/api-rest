package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.services.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class AlumnoRestController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/alumno")
    private List<Alumno> select(){ return alumnoService.findAll(); }

    @GetMapping("/alumno/{id}")
    public Alumno show(@PathVariable Long id){ return alumnoService.findById(id); }

    @PostMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno create(@RequestBody Alumno alumno, @PathVariable Long id){
        alumno.setCliente(alumnoService.findClientById(id));
        return alumnoService.save(alumno);
    }

    @PutMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno update(@RequestBody Alumno alumno,@PathVariable Long id){
        Alumno alumnoActual = alumnoService.findById(id);
        alumnoActual.setActivo(alumno.getActivo());
        alumnoActual.setNivel(alumno.getNivel());
        return alumnoService.save(alumnoActual);
    }

    @DeleteMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ alumnoService.delete(id); }
}
