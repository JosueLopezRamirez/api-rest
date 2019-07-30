package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.models.services.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonaRestController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/persons")
    public List<Persona> select() {
        return personaService.findAll();
    }

    @GetMapping("/persons/{id}")
    public Persona show(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona create(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
        Persona personaActual = personaService.findById(id);
        personaActual.setNombre(persona.getNombre());
        personaActual.setApellido(persona.getApellido());
        return personaService.save(personaActual);
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }
}
