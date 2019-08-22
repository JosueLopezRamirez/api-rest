package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.DTO.DetalleTutoriaDTO;
import com.darkcode.apirest.models.entity.DetalleTutoria;
import com.darkcode.apirest.services.services.IDetalleTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class DetalleTutoriaRestController {

    @Autowired
    private IDetalleTutoriaService detalleTutoriaService;

    @GetMapping("/detalle-tutoria")
    public List<DetalleTutoriaDTO> select(){
        return detalleTutoriaService.findAll();
    }

    @GetMapping("/detalle-tutoria/{id}")
    public DetalleTutoriaDTO show(@PathVariable Long id){
        return detalleTutoriaService.findById(id);
    }

    @PostMapping("/detalle-tutoria")
    public DetalleTutoriaDTO create(@RequestBody DetalleTutoriaDTO detalleTutoriaDTO){
        DetalleTutoria detalleTutoria = new DetalleTutoria(
                detalleTutoriaDTO.getId(),
                detalleTutoriaDTO.getFecha(),
                detalleTutoriaDTO.getHora(),
                detalleTutoriaService.findNivelById(detalleTutoriaDTO.getNivel_id()),
                detalleTutoriaService.findUnidadById(detalleTutoriaDTO.getUnidad_id()),
                detalleTutoriaService.findTutoriaById(detalleTutoriaDTO.getTutoria_id()),
                detalleTutoriaService.findTutorById(detalleTutoriaDTO.getTutor_id())
        );
        return detalleTutoriaService.save(detalleTutoria);
    }

    @DeleteMapping("/detalle-tutoria/{id}")
    public void delete(@PathVariable Long id){
        detalleTutoriaService.delete(id);
    }
}