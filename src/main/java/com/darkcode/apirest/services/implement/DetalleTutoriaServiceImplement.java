package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.DetalleTutoriaDTO;
import com.darkcode.apirest.DTO.DetalleTutoriaDatos;
import com.darkcode.apirest.models.DAO.*;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.services.services.IDetalleTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DetalleTutoriaServiceImplement implements IDetalleTutoriaService {

    @Autowired
    private IDetalleTutoriaDao detalleTutoriaDao;

    @Autowired
    private INivelDao nivelDao;

    @Autowired
    private IUnidadDao unidadDao;

    @Autowired
    private ITutorDao tutorDao;

    @Autowired
    private ITutoriaDao tutoriaDao;

	@Override
    @Transactional(readOnly = true)
    public List<DetalleTutoriaDTO> findAll() {
        List<DetalleTutoria> listaDetalle = (List<DetalleTutoria>) detalleTutoriaDao.findAll();
        List<DetalleTutoriaDTO> listaDto = new ArrayList<DetalleTutoriaDTO>();
        try {
            listaDetalle.forEach( detalleTutoria -> {
                listaDto.add(
                        new DetalleTutoriaDTO(
                                detalleTutoria.getId(),
                                detalleTutoria.getFecha(),
                                detalleTutoria.getHora(),
                                detalleTutoria.getNivel().getId(),
                                detalleTutoria.getUnidad().getId(),
                                detalleTutoria.getTutoria().getId(),
                                detalleTutoria.getTutor().getId()
                        )
                );
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            return listaDto;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleTutoriaDTO findById(Long id) {
        DetalleTutoria detalleTutoria = detalleTutoriaDao.findById(id).orElse(null);
        if(detalleTutoria != null){
            return new DetalleTutoriaDTO(
                    detalleTutoria.getId(),
                    detalleTutoria.getFecha(),
                    detalleTutoria.getHora(),
                    detalleTutoria.getNivel().getId(),
                    detalleTutoria.getUnidad().getId(),
                    detalleTutoria.getTutoria().getId(),
                    detalleTutoria.getTutor().getId()
            );
        }else{
            return null;
        }

    }

    @Override
    @Transactional
    public DetalleTutoriaDTO save(DetalleTutoria detalle) {
        DetalleTutoria detalleTutoria = detalleTutoriaDao.save(detalle);
        if(detalleTutoria != null){
            return new DetalleTutoriaDTO(
                    detalleTutoria.getId(),
                    detalleTutoria.getFecha(),
                    detalleTutoria.getHora(),
                    detalleTutoria.getNivel().getId(),
                    detalleTutoria.getUnidad().getId(),
                    detalleTutoria.getTutoria().getId(),
                    detalleTutoria.getTutor().getId()
            );
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        detalleTutoriaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Nivel findNivelById(Long id) {
        return nivelDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Unidad findUnidadById(Long id) {
        return unidadDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutoria findTutoriaById(Long id) {
        return tutoriaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutor findTutorById(Long id) {
        return tutorDao.findById(id).orElse(null);
    }

	@Override
	@Transactional
	public List<DetalleTutoriaDatos> SP_DETALLE_TUTORIA() {
		List<Object[]> lista = detalleTutoriaDao.SP_DETALLE_TUTORIA();
		List<DetalleTutoriaDatos> listaDevuelta = new ArrayList<>();
		
		lista.forEach(item -> {
			listaDevuelta.add(
					new DetalleTutoriaDatos(
							(BigInteger)item[0],(Date) item[1],(Date) item[2],
							(String) item[3], (String) item[4], (String) item[5],
							(String) item[6])
					);
		});
		return listaDevuelta;
	}
}
