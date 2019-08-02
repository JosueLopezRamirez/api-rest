package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Tutoria;
import com.darkcode.apirest.models.services.services.ITutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TutoriaRestController {

    @Autowired
    private ITutoriaService tutoriaService;

    @GetMapping("/tutoria")
    public List<Tutoria> select(){
        return tutoriaService.findAll();
    }

    @GetMapping("/tutoria/{id}")
    public Tutoria show(@PathVariable Long id){ return tutoriaService.findById(id); }

    @PostMapping("/tutoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutoria create(@RequestBody Tutoria tutoria){ return tutoriaService.save(tutoria); }

    @PutMapping("/tutoria/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutoria update(@RequestBody Tutoria tutoria, @PathVariable Long id){
        Tutoria tutoriaActual = tutoriaService.findById(id);
        tutoriaActual.setDescripcion(tutoria.getDescripcion());
        return tutoriaService.save(tutoriaActual);
    }

    @DeleteMapping("/tutoria/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        tutoriaService.delete(id);
    }
}
