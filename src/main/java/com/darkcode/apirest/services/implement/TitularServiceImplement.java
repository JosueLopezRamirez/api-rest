package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.DAO.ITitularDao;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Titular;
import com.darkcode.apirest.services.services.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Titular findById(Long id) { return titularDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Titular save(Titular titular) { return titularDao.save(titular); }

    @Override
    @Transactional
    public void delete(Long id) { titularDao.deleteById(id); }

    @Override
    @Transactional
    public Cliente findClientById(Long id) { return clienteDao.findById(id).orElse(null); }
}
