package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.MensualidadDTO;
import com.darkcode.apirest.models.DAO.*;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.services.services.IMensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensualdiadServiceImplement implements IMensualidadService {

    @Autowired
    private IMensualidadDao mensualidadDao;

    @Autowired
    private ITitularDao titularDao;

    @Autowired
    private ICobradorDao cobradorDao;

    @Autowired
    private IPlanPagoDao pagoDao;

    @Autowired
    private IFormaDao formaDao;

    @Override
    @Transactional(readOnly = true)
    public List<MensualidadDTO> findAll() {
        List<Mensualidad> mensualidadList = (List<Mensualidad>) mensualidadDao.findAll();
        List<MensualidadDTO> listaDTO = new ArrayList<MensualidadDTO>();

        try {
            mensualidadList.forEach(listaMes -> {
                listaDTO.add(
                        new MensualidadDTO(
                                listaMes.getId(),
                                listaMes.getTitular().getId(),
                                listaMes.getCobrador().getId(),
                                listaMes.getPlanPago().getId(),
                                listaMes.getForma().getId(),
                                listaMes.getFechaPago(),
                                listaMes.getValorPagar(),
                                listaMes.getDiasMora(),
                                listaMes.getSaldoPendiente()
                        )
                );
            });
        }catch (NullPointerException nex){
            nex.printStackTrace();
        }
        return (listaDTO.isEmpty()) ? null : listaDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public MensualidadDTO findById(Long id) {
        Mensualidad mensualidad = mensualidadDao.findById(id).orElse(null);
        if(mensualidad != null){
            return new MensualidadDTO(
                    mensualidad.getId(),
                    mensualidad.getTitular().getId(),
                    mensualidad.getCobrador().getId(),
                    mensualidad.getPlanPago().getId(),
                    mensualidad.getForma().getId(),
                    mensualidad.getFechaPago(),
                    mensualidad.getValorPagar(),
                    mensualidad.getDiasMora(),
                    mensualidad.getSaldoPendiente()
            );
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public MensualidadDTO save(Mensualidad mensualidad) {
        mensualidadDao.save(mensualidad);
        return new MensualidadDTO(
                mensualidad.getId(),
                mensualidad.getTitular().getId(),
                mensualidad.getCobrador().getId(),
                mensualidad.getPlanPago().getId(),
                mensualidad.getForma().getId(),
                mensualidad.getFechaPago(),
                mensualidad.getValorPagar(),
                mensualidad.getDiasMora(),
                mensualidad.getSaldoPendiente()
        );
    }

    @Override
    @Transactional
    public void delete(Long id) {
        mensualidadDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Titular findTitularById(String id) {
        return titularDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cobrador findCobradorById(Long id) {
        return cobradorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public PlanPago findPlanById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public FormaPago findFormaById(Long id) {
        return formaDao.findById(id).orElse(null);
    }
}