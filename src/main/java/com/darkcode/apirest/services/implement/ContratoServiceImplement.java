package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.ContratoDTO;
import com.darkcode.apirest.models.DAO.*;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.services.services.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
                            Long.parseLong(con.getContratoId().getAlumno().getId()),
                            Long.parseLong(con.getContratoId().getTitular().getId()),
                            con.getContratoId().getAsesor().getId(),
                            con.getEstrategia().getId(),
                            con.getPlanPago().getId(),
                            con.getFormaPago().getId(),
                            con.getFechaContrato()
                    )
            );
        }
        return contratoDTO;
    }

    //Seleccionamos un contrato en formato POJO y lo pasamos a DTO para devolver un formato mas ligero
    @Override
    @Transactional(readOnly = true)
    public ContratoDTO findContratoDtoById(Long id) {
        Contrato con = contratoDao.findById(id).orElse(null);
        if(con != null){
            ContratoDTO contratoDto = new ContratoDTO();
            contratoDto.setAlumno_id(Long.valueOf(con.getContratoId().getAlumno().getId()));
            contratoDto.setTitular_id(Long.valueOf(con.getContratoId().getTitular().getId()));
            contratoDto.setAsesor_id(con.getContratoId().getAsesor().getId());
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

    //Metodos para obtener los id de los objetos que se integran por medio del id
    @Override
    @Transactional(readOnly = true)
    public Alumno findAlumnoById(Long id) {
        return alumnoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Titular findTitularById(Long id) {
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
