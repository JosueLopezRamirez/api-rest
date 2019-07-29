package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.petitions.Employee;
import com.darkcode.apirest.models.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/employees")
    public List<Empleado> select() {
        return (List<Empleado>) empleadoService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Empleado show(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado create(@RequestBody Employee employee) {
        //Creando usuario temporal y pasando los parametros del user recibido
        Empleado empleado = new Empleado();
        empleado.setSalario(employee.getSalario());
        /** Asignandole el objeto empleado completo haciendo uso del IempleadoDao que esta dentro de usuarioService,
         * para pasarle el ultimo usuario empleado ingresado*/
        empleado.setPersona(empleadoService.findPersonById(employee.getPersona_id()));
        return empleadoService.save(empleado);
    }

    //Metodo para actualizar ciertos campos de un usuairo en la base de datos
    @PutMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody Employee employee, @PathVariable Long id) {
        /*
         * Asignando los valores del usuario enviado por el cliente a un objeto temporal
         * esto para luego ser enviado a la base datos
         * */
        Empleado empladoActual = empleadoService.findById(id);
        empladoActual.setSalario(employee.getSalario());
        //Metodo save del service al tener un id, usara un merge lo cual se traducira a un update a la base de datos
        return empleadoService.save(empladoActual);
    }

    //Metodo para eliminar un usuario de la base de datos
    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}
