package com.darkcode.apirest.services.services;

import com.darkcode.apirest.DTO.DetalleTutoriaDTO;
import com.darkcode.apirest.DTO.DetalleTutoriaDatos;
import com.darkcode.apirest.models.entity.*;

import java.util.List;

public interface IDetalleTutoriaService {

    public List<DetalleTutoriaDTO> findAll();

    public DetalleTutoriaDTO findById(Long id);

    public DetalleTutoriaDTO save(DetalleTutoria detalleTutoria);

    public void delete(Long id);

    public Nivel findNivelById(Long id);

    public Unidad findUnidadById(Long id);

    public Tutoria findTutoriaById(Long id);

    public Tutor findTutorById(Long id);
    
    // -> Metodos que llaman procedimientos almacenados
    public List<DetalleTutoriaDatos> SP_DETALLE_TUTORIA();
}
