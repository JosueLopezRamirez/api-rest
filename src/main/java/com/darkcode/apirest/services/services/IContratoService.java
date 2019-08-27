package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.DTO.RecordProduccion;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.models.entity.composite.ContratoId;

import java.util.Date;
import java.util.List;

public interface IContratoService {

    public List<ContratoDTO> findAllContratoDto();

    public List<RecordProduccion> recordProduccion();

    public ContratoDTO findContratoDtoById(ContratoId id);

    public List<Contrato> findAll();

    public Contrato findById(ContratoId id);

    public Contrato save(Contrato contrato);

    public void delete(ContratoId id);

    public Alumno findAlumnoById(String id);

    public Titular findTitularById(String id);

    public Asesor findAsesorById(Long id);

    public Estrategia findEstrategiaById(Long id);

    public PlanPago findPlanById(Long id);

    public FormaPago findFormaById(Long id);

//    public Object[] INSERT_CONTRATO(String fecha, String titular_id, String alumno_id, Long asesor, Long estrategia, Long forma, Long plan);
}
