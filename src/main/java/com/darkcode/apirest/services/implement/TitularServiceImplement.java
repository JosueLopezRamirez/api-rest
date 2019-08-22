package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.DatosTitular;
import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.DAO.ITitularDao;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Titular;
import com.darkcode.apirest.services.services.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class TitularServiceImplement implements ITitularService {

    @Autowired
    private ITitularDao titularDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly =  true)
    public List<Titular> findAll() { return (List<Titular>) titularDao.findAll(); }

    @Override
    @Transactional(readOnly =  true)
    public Titular findById(String id) { return titularDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Titular save(Titular titular) { return titularDao.save(titular); }

    @Override
    @Transactional
    public void delete(String id) { titularDao.deleteById(id); }

    @Override
    @Transactional
    public List<DatosTitular> SP_GET_DATOS_TITULARES() {
        List<Object[]> lista = titularDao.SP_GET_DATOS_TITULARES();
        List<DatosTitular> listaDevuelta = new ArrayList<>();

        lista.forEach(item -> {
            listaDevuelta.add(
                    new DatosTitular(
                            (String) item[0], (BigInteger) item[1],
                            (BigInteger) item[2], (String) item[3],
                            (String) item[4], (String) item[5],
                            (float) item[6], (String) item[7],
                            (String) item[8], (String) item[9],
                            (String) item[10], (String) item[11]
                    )
            );
        });

        return listaDevuelta;
    }

    @Override
    @Transactional
    public Cliente findClientById(Long id) { return clienteDao.findById(id).orElse(null); }
}
