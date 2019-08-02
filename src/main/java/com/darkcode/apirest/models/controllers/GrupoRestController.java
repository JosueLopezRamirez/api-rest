package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.models.entity.petitions.Group;
import com.darkcode.apirest.models.services.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class GrupoRestController {

    @Autowired
    private IGrupoService grupoService;

    @GetMapping("/grupos")
    public List<Grupo> select() { return grupoService.findAll(); }

    @GetMapping("/grupos/{id}")
    public Grupo show(@PathVariable Long id){ return grupoService.findById(id); }

    @PostMapping("/grupos")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo create(@RequestBody Group group){
        Grupo grupo = new Grupo();
        grupo.setNombreGrupo(group.getNombreGrupo());
        grupo.setOrganizacion(grupoService.findOrganizationById(group.getOrganizacion_id()));
        return grupoService.save(grupo);
    }

    @PutMapping("/grupos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo update(@RequestBody Group group,@PathVariable Long id){
        Grupo grupoActual = grupoService.findById(id);
        grupoActual.setNombreGrupo(group.getNombreGrupo());
        grupoActual.setOrganizacion(grupoService.findOrganizationById(group.getOrganizacion_id()));
        return grupoService.save(grupoActual);
    }

    @DeleteMapping("/grupos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ grupoService.delete(id); }
}