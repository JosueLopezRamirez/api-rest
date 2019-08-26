package com.darkcode.apirest.controllers;


import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.EmpleadoDTO;
import com.darkcode.apirest.services.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> select() {
        return (List<Empleado>) empleadoService.findAll();
    }

    @GetMapping("/empleados/{id}")
    public Empleado show(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado create(@RequestBody EmpleadoDTO empleadoDTO) {
        //Creando usuario temporal y pasando los parametros del user recibido
        Empleado empleado = new Empleado();
        empleado.setSalario(empleadoDTO.getSalario());
        /** Asignandole el objeto empleado completo haciendo uso del IempleadoDao que esta dentro de usuarioService,
         * para pasarle el ultimo usuario empleado ingresado*/
        empleado.setPersona(empleadoService.findPersonById(empleadoDTO.getPersona_id()));
        return empleadoService.save(empleado);
    }

    //Metodo para actualizar ciertos campos de un usuairo en la base de datos
    @PutMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable Long id) {
        /*
         * Asignando los valores del usuario enviado por el cliente a un objeto temporal
         * esto para luego ser enviado a la base datos
         * */
        Empleado empladoActual = empleadoService.findById(id);
        empladoActual.setSalario(empleadoDTO.getSalario());
        //Metodo save del service al tener un id, usara un merge lo cual se traducira a un update a la base de datos
        return empleadoService.save(empladoActual);
    }

    //Metodo para eliminar un usuario de la base de datos
    @DeleteMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}
