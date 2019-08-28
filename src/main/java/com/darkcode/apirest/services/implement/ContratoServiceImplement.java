package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.DTO.RecordProduccion;
import com.darkcode.apirest.models.DAO.*;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.services.services.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {

    @Autowired
    private IContratoDao contratoDao;

    @Autowired
    private IAlumnoDao alumnoDao;

    @Autowired
    private ITitularDao titularDao;

    @Autowired
    private IAsesorDao asesorDao;

    @Autowired
    private IEstrategiaDao estrategiaDao;

    @Autowired
    private IPlanPagoDao planPagoDao;

    @Autowired
    private IFormaDao formaDao;

    //Obtener una lista entera en POJO puro y pasarla a DTO, formato mas ligero
    @Override
    @Transactional(readOnly = true)
    public List<ContratoDTO> findAllContratoDto() {
        List<ContratoDTO> contratoDTO = new ArrayList<ContratoDTO>();
        List<Contrato> contrato = (List<Contrato>) contratoDao.findAll();
        for(Contrato con: contrato){
            contratoDTO.add(
                    new ContratoDTO(
                            con.getAlumno().getId(),
                            con.getTitular().getId(),
                            con.getAsesor().getId(),
                            con.getEstrategia().getId(),
                            con.getPlanPago().getId(),
                            con.getFormaPago().getId(),
                            con.getFechaContrato()
                    )
            );
        }
        return contratoDTO;
    }

    @Override
    @Transactional
    public List<RecordProduccion> recordProduccion() {
        List<Object[]> lista = contratoDao.SP_RECORD_PRODUCCION();
        List<RecordProduccion> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> {
            listaDevuelta.add(
                    new RecordProduccion(
                            (Date) item[0], (String) item[1],
                            (String) item[2],(float) item[3],
                            (float) item[4],(float) item[5],
                            (float) item[6],(String) item[7],
                            (String) item[8],(String) item[9],
                            (String) item[10],/*(String) item[11]*/ null
                    )
            );
        });
        return listaDevuelta;
    }

    @Override
    @Transactional(readOnly = true)
    public ContratoDTO findContratoDtoById(Long id) {
        Contrato con = contratoDao.findById(id).orElse(null);
        if(con != null){
            ContratoDTO contratoDto = new ContratoDTO();
            contratoDto.setAlumno_id(con.getAlumno().getId());
            contratoDto.setTitular_id(con.getTitular().getId());
            contratoDto.setAsesor_id(con.getAsesor().getId());
            contratoDto.setEstrategia_id(con.getEstrategia().getId());
            contratoDto.setPlan_id(con.getPlanPago().getId());
            contratoDto.setForma_id(con.getFormaPago().getId());
            contratoDto.setFechaContrato(con.getFechaContrato());

            return contratoDto;
        }else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrato> findAll() {
        return (List<Contrato>) contratoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Contrato findById(Long id) {
        return contratoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Contrato save(Contrato contrato) {
        return contratoDao.save(contrato);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        contratoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno findAlumnoById(String id) {
        return alumnoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Titular findTitularById(String id) {
        return titularDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Asesor findAsesorById(Long id) {
        return asesorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Estrategia findEstrategiaById(Long id) {
        return estrategiaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public PlanPago findPlanById(Long id) {
        return planPagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public FormaPago findFormaById(Long id) {
        return formaDao.findById(id).orElse(null);
    }

}
