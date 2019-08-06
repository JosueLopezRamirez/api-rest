package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.DTO.ClienteDTO;
import com.darkcode.apirest.services.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> select(){ return clienteService.findAll(); }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){ return clienteService.findById(id); }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCedula(clienteDTO.getCedula());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setPersona(clienteService.findPersonById(clienteDTO.getPersona_id()));
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setDireccion(clienteDTO.getDireccion());
        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ clienteService.delete(id); }
}
