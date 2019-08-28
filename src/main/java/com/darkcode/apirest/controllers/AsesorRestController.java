package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.Asesor;
import com.darkcode.apirest.DTO.AsesorDTO;
import com.darkcode.apirest.DTO.AsesorNames;
import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.services.services.IAsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
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
    
    @GetMapping("/asesores-nombres")
    public List<AsesorNames> findAllNames(){
    	return asesorService.buscarAsesorNombreApellido();
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
