package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.MensualidadDTO;
import com.darkcode.apirest.models.entity.*;

import java.util.List;

public interface IMensualidadService {

    public List<MensualidadDTO> findAll();

    public MensualidadDTO findById(Long id);

    public MensualidadDTO save(Mensualidad mensualidad);

    public void delete(Long id);

    public Titular findTitularById(String id);

    public Cobrador findCobradorById(Long id);

    public PlanPago findPlanById(Long id);

    public FormaPago findFormaById(Long id);
}
