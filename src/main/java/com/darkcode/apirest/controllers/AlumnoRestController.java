package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.*;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.services.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class AlumnoRestController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/alumnos")
    private List<Alumno> select(){ return alumnoService.findAll(); }

    @GetMapping("/alumnos/{id}")
    public Alumno show(@PathVariable String id){ return alumnoService.findById(id); }

    @GetMapping("/alumnos-datos")
    public List<DatosAlumnos> datosAlumnos(){
        return alumnoService.SP_GET_DATOS_ALUMNOS();
    }

    @PostMapping("/alumnos-reserva-activa")
    public List<ReservaAlumno> datosAlumnos(@RequestBody Reserva reserva){
        return alumnoService.SP_LISTA_ALUMNOS_RESERVA(reserva.getFecha(),reserva.getHora());
    }

    @GetMapping("/alumnos-historial/{id}")
    public List<GreenHistorial> historialAlumno(@PathVariable String id){
    	return alumnoService.SP_GET_HISTORIAL_ACADEMICO(id);
    }
    
    @PostMapping("/alumnos-historial-datos")
    public DatosGreen datosHistorialAlumno(@RequestBody String nombre){
    	return alumnoService.SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(nombre);
    }
    
    @PostMapping("/alumnos-existe")
    public int alumnoExiste(@RequestBody String nombre){
    	return alumnoService.ALUMNO_NOMBRE_COMPLETO_EXISTE(nombre);
    }
    
    
    @PostMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno create(@RequestBody Alumno alumno, @PathVariable Long id){
        alumno.setCliente(alumnoService.findClientById(id));
        return alumnoService.save(alumno);
    }

    @PutMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno update(@RequestBody AlumnoDTO alumno, @PathVariable String id){
        Alumno alumnoActual = alumnoService.findById(id);
        alumnoActual.setActivo(alumno.isActivo());
        alumnoActual.setNivel(alumno.getNivel());
        return alumnoService.save(alumnoActual);
    }

    @DeleteMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){ alumnoService.delete(id); }
}
