package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Tutor;
import com.darkcode.apirest.models.services.services.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TutorRestController {

    @Autowired
    private ITutorService tutorService;

    @GetMapping("/tutor")
    public List<Tutor> select(){
        return tutorService.findAll();
    }

    @GetMapping("/tutor/{id}")
    public Tutor show(@PathVariable Long id){ return tutorService.findById(id); }

    @PostMapping("/tutor")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor create(@RequestBody Tutor tutor){ return tutorService.save(tutor); }

    @PutMapping("/tutor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor update(@RequestBody Tutor tutor, @PathVariable Long id){
        Tutor tutorActual = tutorService.findById(id);
        tutorActual.setNombre(tutor.getNombre());
        return tutorService.save(tutorActual);
    }

    @DeleteMapping("/tutor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        tutorService.delete(id);
    }
}
