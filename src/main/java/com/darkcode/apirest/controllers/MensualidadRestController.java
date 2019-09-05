package com.darkcode.apirest.controllers;


import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.*;
import com.darkcode.apirest.models.entity.Mensualidad;
import com.darkcode.apirest.services.services.IMensualidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class MensualidadRestController {

    @Autowired
    private IMensualidadService mensualidadService;

    Logger log = LoggerFactory.getLogger(MensualidadRestController.class);

    @GetMapping("/mensualidades")
    public List<MensualidadDTO> select(){
        return mensualidadService.findAll();
    }

    @GetMapping("/mensualidades/{id}")
    public MensualidadDTO show(@PathVariable Long id){
        return mensualidadService.findById(id);
    }

    @PostMapping("/mensualidades")
    @ResponseStatus(HttpStatus.CREATED)
    public MensualidadDTO create(@RequestBody MensualidadDTO mensualidadDTO){
        return mensualidadService.save(mensualidadDTO);
    }

    @PostMapping("/mensualidades-pendientes")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PagosPendientes> pendientes(@RequestBody Pago pago){
        log.info(pago.toString());
        return mensualidadService.SP_MENSUALIDAD_PENDIENTES(pago.getFecha_inicio(),pago.getFecha_fin(),pago.getFecha_actual());
    }

    @PostMapping("/mensualidades-canceladas")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PagosPendientes> canceladas(@RequestBody Pago pago){
        log.info(pago.toString());
        return mensualidadService.SP_MENSUALIDAD_CANCELADOS(pago.getFecha_inicio(),pago.getFecha_fin());
    }

    @PostMapping("/mensualidades-pagado")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EstadoCambiado> pagar_cancelar(@RequestBody EfectuarPago pago){
        log.info(pago.toString());
        return mensualidadService.SP_CAMBIAR_ESTADO_MENSUALIDAD(pago.isPagado(),pago.getId());
    }

    @PostMapping("/mensualidades-estado-cuenta/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EstadoCuenta> pagar_cancelar(@PathVariable String id){
        return mensualidadService.SP_ESTADO_CUENTA(id);
    }

    @GetMapping("/mensualidades-atrasados")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PagosPendientes> atrasados(){
        return mensualidadService.SP_MENSUALIDAD_ATRASADOS();
    }

    @GetMapping("/mensualidades-totales")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PagosPendientes> totales(){
        return mensualidadService.SP_MENSUALIDAD_CANCELADOS_TOTALES();
    }

    @PutMapping("/mensualidades/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MensualidadDTO update(@RequestBody MensualidadDTO mensualidad,@PathVariable Long id){
        MensualidadDTO menActual = mensualidadService.findById(id);

        menActual.setFecha_pago(mensualidad.getFecha_pago());
        menActual.setCobrador_id(mensualidad.getCobrador_id());
        menActual.setDias_mora(mensualidad.getDias_mora());
        menActual.setForma_id(mensualidad.getForma_id());
        menActual.setSaldo_pendiente(mensualidad.getSaldo_pendiente());
        menActual.setValor_pagar(mensualidad.getValor_pagar());
        return mensualidadService.save(menActual);
    }

    @DeleteMapping("/mensualidades/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        mensualidadService.delete(id);
    }
}