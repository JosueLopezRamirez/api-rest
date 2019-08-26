package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Tutor;
import com.darkcode.apirest.services.services.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class TutorRestController {

    @Autowired
    private ITutorService tutorService;

    @GetMapping("/tutores")
    public List<Tutor> select(){
        return tutorService.findAll();
    }

    @GetMapping("/tutores/{id}")
    public Tutor show(@PathVariable Long id){ return tutorService.findById(id); }

    @PostMapping("/tutores")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor create(@RequestBody Tutor tutor){ return tutorService.save(tutor); }

    @PutMapping("/tutores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor update(@RequestBody Tutor tutor, @PathVariable Long id){
        Tutor tutorActual = tutorService.findById(id);
        tutorActual.setNombre(tutor.getNombre());
        return tutorService.save(tutorActual);
    }

    @DeleteMapping("/tutores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        tutorService.delete(id);
    }
}
