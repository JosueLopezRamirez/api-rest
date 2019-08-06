package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.models.entity.*;

import java.util.List;

public interface IContratoService {

    public List<ContratoDTO> findAllContratoDto();

    public ContratoDTO findContratoDtoById(Long id);

    public List<Contrato> findAll();

    public Contrato findById(Long id);

    public Contrato save(Contrato contrato);

    public void delete(Long id);

    public Alumno findAlumnoById(String id);

    public Titular findTitularById(String id);

    public Asesor findAsesorById(Long id);

    public Estrategia findEstrategiaById(Long id);

    public PlanPago findPlanById(Long id);

    public FormaPago findFormaById(Long id);
}
