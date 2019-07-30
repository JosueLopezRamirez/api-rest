package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.models.entity.Organizacion;
import com.darkcode.apirest.models.services.services.IOrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class OrganizacionRestController {

    @Autowired
    private IOrganizacionService organizacionService;

    @GetMapping("/orgs")
    public List<Organizacion> select() {
        return organizacionService.findAll();
    }

    @GetMapping("/orgs/{id}")
    public Organizacion show(@PathVariable Long id) {
        return organizacionService.findById(id);
    }

    @PostMapping("/orgs")
    @ResponseStatus(HttpStatus.CREATED)
    public Organizacion create(@RequestBody Organizacion organizacion) { return organizacionService.save(organizacion); }

    @PutMapping("/orgs/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Organizacion update(@RequestBody Organizacion organizacion, @PathVariable Long id) {
        Organizacion organizacionActual = organizacionService.findById(id);
        organizacionActual.setNombreOrganizacion(organizacion.getNombreOrganizacion());
        return organizacionService.save(organizacionActual);
    }

    @DeleteMapping("/orgs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { organizacionService.delete(id); }
}
