package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.ReservaTutoriaDTO;
import com.darkcode.apirest.models.DAO.IAlumnoDao;
import com.darkcode.apirest.models.DAO.IDetalleTutoriaDao;
import com.darkcode.apirest.models.DAO.IReservaDao;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.DetalleTutoria;
import com.darkcode.apirest.models.entity.ReservaTutoria;
import com.darkcode.apirest.models.entity.composite.ReservaId;
import com.darkcode.apirest.services.services.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImplement implements IReservaService {

    @Autowired
    private IReservaDao reservaDao;

    @Autowired
    private IAlumnoDao alumnoDao;

    @Autowired
    private IDetalleTutoriaDao detalleDao;

    @Override
    @Transactional(readOnly = true)
    public List<ReservaTutoriaDTO> findAll() {
        List<ReservaTutoria> listaReserva = (List<ReservaTutoria>) reservaDao.findAll();
        List<ReservaTutoriaDTO> listaDto = new ArrayList<ReservaTutoriaDTO>();

        listaReserva.forEach(reservaTutoria -> {
            listaDto.add(
                    new ReservaTutoriaDTO(
                            //String alumno_id, Date fecha_reserva, boolean reprogramada, boolean aprovada
                            reservaTutoria.getId().getAlumno().getId(),
                            reservaTutoria.getId().getDetalleTutoria().getFechaReserva(),
                            reservaTutoria.isReprogramada(),
                            reservaTutoria.isAprobada()
                    )
            );
        });
        return listaDto;
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaTutoriaDTO findById(ReservaId id) {
        ReservaTutoria reserva = reservaDao.findById(id).orElse(null);
        if (reserva != null){
            return new ReservaTutoriaDTO(
                    //String alumno_id, Date fecha_reserva, boolean reprogramada, boolean aprovada
                    reserva.getId().getAlumno().getId(),
                    reserva.getId().getDetalleTutoria().getFechaReserva(),
                    reserva.isReprogramada(),
                    reserva.isAprobada()
            );
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public ReservaTutoriaDTO save(ReservaTutoria reserva) {
        if (reserva != null){
            reservaDao.save(reserva);
            return new ReservaTutoriaDTO(
                    //String alumno_id, Date fecha_reserva, boolean reprogramada, boolean aprovada
                    reserva.getId().getAlumno().getId(),
                    reserva.getId().getDetalleTutoria().getFechaReserva(),
                    reserva.isReprogramada(),
                    reserva.isAprobada()
            );
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(ReservaId id) {
        reservaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno findAlumnoById(String id) {
        return alumnoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleTutoria findDetalleById(Date id) {
        return detalleDao.findById(id).orElse(null);
    }
}