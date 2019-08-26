package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Organizacion;
import com.darkcode.apirest.services.services.IOrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class OrganizacionRestController {

    @Autowired
    private IOrganizacionService organizacionService;

    @GetMapping("/organizaciones")
    public List<Organizacion> select() {
        return organizacionService.findAll();
    }

    @GetMapping("/organizaciones/{id}")
    public Organizacion show(@PathVariable Long id) {
        return organizacionService.findById(id);
    }

    @PostMapping("/organizaciones")
    @ResponseStatus(HttpStatus.CREATED)
    public Organizacion create(@RequestBody Organizacion organizacion) { return organizacionService.save(organizacion); }

    @PutMapping("/organizaciones/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Organizacion update(@RequestBody Organizacion organizacion, @PathVariable Long id) {
        Organizacion organizacionActual = organizacionService.findById(id);
        organizacionActual.setNombreOrganizacion(organizacion.getNombreOrganizacion());
        return organizacionService.save(organizacionActual);
    }

    @DeleteMapping("/organizaciones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { organizacionService.delete(id); }
}
