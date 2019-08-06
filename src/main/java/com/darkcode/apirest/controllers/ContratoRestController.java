package com.darkcode.apirest.controllers;

import com.darkcode.apirest.ApiRestApplication;
import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.models.entity.Contrato;
import com.darkcode.apirest.services.services.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {ApiRestApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ContratoRestController {

    @Autowired
    private IContratoService contratoService;

    @GetMapping("/contratos")
    public List<Contrato> select(){
        return contratoService.findAll();
    }

    @GetMapping("/contratos/dto")
    public List<ContratoDTO> selectDto(){
        return contratoService.findAllContratoDto();
    }
}
