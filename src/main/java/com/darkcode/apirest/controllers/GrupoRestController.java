package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Grupo;
import com.darkcode.apirest.DTO.GrupoDTO;
import com.darkcode.apirest.services.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
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
    public Grupo create(@RequestBody GrupoDTO grupoDTO){
        Grupo grupo = new Grupo();
        grupo.setNombreGrupo(grupoDTO.getNombreGrupo());
        grupo.setOrganizacion(grupoService.findOrganizationById(grupoDTO.getOrganizacion_id()));
        return grupoService.save(grupo);
    }

    @PutMapping("/grupos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo update(@RequestBody GrupoDTO grupoDTO, @PathVariable Long id){
        Grupo grupoActual = grupoService.findById(id);
        grupoActual.setNombreGrupo(grupoDTO.getNombreGrupo());
        grupoActual.setOrganizacion(grupoService.findOrganizationById(grupoDTO.getOrganizacion_id()));
        return grupoService.save(grupoActual);
    }

    @DeleteMapping("/grupos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ grupoService.delete(id); }
}