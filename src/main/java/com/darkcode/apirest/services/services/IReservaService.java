package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.ReservaTutoriaDTO;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.DetalleTutoria;
import com.darkcode.apirest.models.entity.ReservaTutoria;
import com.darkcode.apirest.models.entity.composite.ReservaId;

import java.util.Date;
import java.util.List;

public interface IReservaService {

    public List<ReservaTutoriaDTO> findAll();

    public ReservaTutoriaDTO findById(ReservaId id);

    public ReservaTutoriaDTO save(ReservaTutoria reservaTutoria);

    public void delete(ReservaId id);

    public Alumno findAlumnoById(String id);

    public DetalleTutoria findDetalleById(Date id);
}
