package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.models.entity.FormaPago;
import com.darkcode.apirest.services.services.IFormaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class FormaRestController {

    @Autowired
    private IFormaService formaService;

    @GetMapping("/formas")
    public List<FormaPago> select(){
        return formaService.findAll();
    }

    @GetMapping("/formas/{id}")
    public FormaPago show(@PathVariable Long id){ return formaService.findById(id); }

    @PostMapping("/formas")
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPago create(@RequestBody FormaPago formaPago){ return formaService.save(formaPago); }

    @PutMapping("/formas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPago update(@RequestBody FormaPago formaPago, @PathVariable Long id){
        FormaPago formaActual = formaService.findById(id);
        formaActual.setDescripcion(formaPago.getDescripcion());
        return formaService.save(formaActual);
    }

    @DeleteMapping("/formas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        formaService.delete(id);
    }
}
