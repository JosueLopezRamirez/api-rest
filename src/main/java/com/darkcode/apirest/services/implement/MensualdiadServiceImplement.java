package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.EstadoCambiado;
import com.darkcode.apirest.DTO.EstadoCuenta;
import com.darkcode.apirest.DTO.MensualidadDTO;
import com.darkcode.apirest.DTO.PagosPendientes;
import com.darkcode.apirest.models.DAO.*;
import com.darkcode.apirest.models.entity.*;
import com.darkcode.apirest.services.services.IMensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    public MensualidadDTO save(MensualidadDTO mensualidadDTO) {
        Mensualidad mensualidad = new Mensualidad();
        mensualidad.setCobrador(findCobradorById(mensualidadDTO.getCobrador_id()));
        mensualidad.setDiasMora((short)mensualidadDTO.getDias_mora());
        mensualidad.setFechaPago(mensualidadDTO.getFecha_pago());
        mensualidad.setForma(findFormaById(mensualidadDTO.getForma_id()));
        mensualidad.setPlanPago(findPlanById(mensualidadDTO.getPlan_id()));
        mensualidad.setSaldoPendiente(mensualidadDTO.getSaldo_pendiente());
        mensualidad.setTitular(findTitularById(mensualidadDTO.getTitular_id()));
        mensualidad.setValorPagar(mensualidadDTO.getValor_pagar());
        return (mensualidadDao.save(mensualidad)!=null)?mensualidadDTO:null;
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

    @Override
    @Transactional
    public List<PagosPendientes> SP_MENSUALIDAD_PENDIENTES(Date fecha_inicio, Date fecha_fin, Date fecha_actual) {
        List<Object[]> lista = mensualidadDao.SP_MENSUALIDAD_PENDIENTES(fecha_inicio,fecha_fin,fecha_actual);
        return getPagosPendientes(lista);
    }

    @Override
    @Transactional
    public List<PagosPendientes> SP_MENSUALIDAD_ATRASADOS() {
        List<Object[]> lista = mensualidadDao.SP_MENSUALIDAD_ATRASADOS();
        return getPagosPendientes(lista);
    }

    @Override
    @Transactional
    public List<PagosPendientes> SP_MENSUALIDAD_CANCELADOS(Date fecha_inicio, Date fecha_fin) {
        List<Object[]> lista = mensualidadDao.SP_MENSUALIDAD_CANCELADOS(fecha_inicio,fecha_fin);
        return getPagosPendientes(lista);
    }

    @Override
    @Transactional
    public List<EstadoCambiado> SP_CAMBIAR_ESTADO_MENSUALIDAD(boolean estado, Long id) {
        List<Object[]> lista = mensualidadDao.SP_CAMBIAR_ESTADO_MENSUALIDAD(estado,id);
        List<EstadoCambiado> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> {
            listaDevuelta.add(new EstadoCambiado((String)item[0],(String)item[1]));
        });
        return listaDevuelta;
    }

    @Override
    @Transactional
    public List<PagosPendientes> SP_MENSUALIDAD_CANCELADOS_TOTALES() {
        List<Object[]> lista = mensualidadDao.SP_MENSUALIDAD_CANCELADOS_TOTALES();
        return getPagosPendientes(lista);
    }

    @Override
    @Transactional
    public List<EstadoCuenta> SP_ESTADO_CUENTA(String id) {
        List<Object[]> lista = mensualidadDao.SP_ESTADO_CUENTA(id);
        List<EstadoCuenta> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> listaDevuelta.add(new EstadoCuenta((String)item[0],(Date) item[1],(float)item[2],(float)item[3],(boolean)item[4],(BigInteger)item[5])));
        return listaDevuelta;
    }

    //Metodo para evitar codigo duplicado
    private List<PagosPendientes> getPagosPendientes(List<Object[]> lista) {
        List<PagosPendientes> listaDevuelta = new ArrayList<>();

        lista.forEach(item -> {
            listaDevuelta.add(
                    new PagosPendientes(
                            (String)item[0],(String)item[1],(Date)item[2],
                            (float)item[3],(float)item[4],(BigInteger)item[5]
                    )
            );
        });
        return listaDevuelta;
    }
}