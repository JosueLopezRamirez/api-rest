package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.DetalleTutoriaDTO;
import com.darkcode.apirest.models.entity.*;

import java.util.Date;
import java.util.List;

public interface IDetalleTutoriaService {

    public List<DetalleTutoriaDTO> findAll();

    public DetalleTutoriaDTO findById(Date id);

    public DetalleTutoriaDTO save(DetalleTutoria detalleTutoria);

    public void delete(Date fecha,Date hora);

    public Nivel findNivelById(Long id);

    public Unidad findUnidadById(Long id);

    public Tutoria findTutoriaById(Long id);

    public Tutor findTutorById(Long id);
}
