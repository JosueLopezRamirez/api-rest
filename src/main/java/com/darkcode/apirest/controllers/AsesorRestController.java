package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.DTO.AsesorDTO;
import com.darkcode.apirest.services.services.IAsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class AsesorRestController {

    @Autowired
    private IAsesorService asesorService;

    @GetMapping("/asesores")
    public List<Asesor> select() {
        return asesorService.findAll();
    }

    @GetMapping("/asesores/{id}")
    public Asesor show(@PathVariable Long id){
        return asesorService.findById(id);
    }

    @PostMapping("/asesores")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor create(@RequestBody AsesorDTO asesorDTO){
        Asesor asesor = new Asesor();
        asesor.setEmpleado(asesorService.findEmployeeById(asesorDTO.getEmpleado_id()));
        asesor.setGrupo(asesorService.findGroupById(asesorDTO.getGrupo_id()));
        return asesorService.save(asesor);
    }

    @PutMapping("/asesores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor update(@RequestBody AsesorDTO asesorDTO, @PathVariable Long id){
        Asesor asesorActual = asesorService.findById(id);
        asesorActual.setGrupo(asesorService.findGroupById(asesorDTO.getGrupo_id()));
        return asesorService.save(asesorActual);
    }

    @DeleteMapping("/asesores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ asesorService.delete(id); }
}
