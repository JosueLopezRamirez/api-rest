package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.EstadoCambiado;
import com.darkcode.apirest.DTO.MensualidadDTO;
import com.darkcode.apirest.DTO.PagosPendientes;
import com.darkcode.apirest.models.entity.*;

import java.util.Date;
import java.util.List;

public interface IMensualidadService {

    public List<MensualidadDTO> findAll();

    public MensualidadDTO findById(Long id);

    public MensualidadDTO save(MensualidadDTO MensualidadDTO);

    public void delete(Long id);

    public Titular findTitularById(String id);

    public Cobrador findCobradorById(Long id);

    public PlanPago findPlanById(Long id);

    public FormaPago findFormaById(Long id);

    public List<PagosPendientes> SP_MENSUALIDAD_PENDIENTES(Date fecha_inicio, Date fecha_fin, Date fecha_actual);

    public List<PagosPendientes> SP_MENSUALIDAD_ATRASADOS();

    public List<PagosPendientes> SP_MENSUALIDAD_CANCELADOS(Date fecha_inicio,Date fecha_fin);

    public List<EstadoCambiado> SP_CAMBIAR_ESTADO_MENSUALIDAD(boolean estado, Long id);

    public List<PagosPendientes> SP_MENSUALIDAD_CANCELADOS_TOTALES();
}
