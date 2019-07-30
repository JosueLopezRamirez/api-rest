package com.darkcode.apirest.models.controllers;

import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.petitions.Client;
import com.darkcode.apirest.models.services.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
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
    public Cliente create(@RequestBody Client client){
        Cliente cliente = new Cliente();
        cliente.setCedula(client.getCedula());
        cliente.setDireccion(client.getDireccion());
        cliente.setPersona(clienteService.findPersonById(client.getId()));
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Client client,@PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setDireccion(client.getDireccion());
        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ clienteService.delete(id); }
}
