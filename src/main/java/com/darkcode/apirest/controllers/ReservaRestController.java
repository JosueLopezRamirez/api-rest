package com.darkcode.apirest.controllers;

import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.ReservaTutoriaDTO;
import com.darkcode.apirest.models.entity.ReservaTutoria;
import com.darkcode.apirest.models.entity.composite.ReservaId;
import com.darkcode.apirest.services.services.IReservaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class ReservaRestController {
    @Autowired
    private IReservaService reservaService;

    private Logger log = LoggerFactory.getLogger(ReservaRestController.class);

    @GetMapping("/reservas")
    public List<ReservaTutoriaDTO> select(){
        return reservaService.findAll();
    }

    @GetMapping("/reservas/{id}")
    public ReservaTutoriaDTO show(@PathVariable ReservaId id){
        return reservaService.findById(id);
    }

    @PostMapping("/reservas")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaTutoriaDTO create(@RequestBody ReservaTutoriaDTO reservaDTO){
        log.info("Reserva enviada "+reservaDTO.toString());
        ReservaTutoria reserva = new ReservaTutoria(
                new ReservaId(
                        reservaService.findAlumnoById(reservaDTO.getAlumno_id()),
                        reservaService.findDetalleById(reservaDTO.getDetalle_id())
                ),
                reservaDTO.isReprogramada(),
                reservaDTO.isAprovada()
        );
        return reservaService.save(reserva);
    }

    @DeleteMapping("/reservas")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody ReservaId id){
        reservaService.delete(id);
    }
}
