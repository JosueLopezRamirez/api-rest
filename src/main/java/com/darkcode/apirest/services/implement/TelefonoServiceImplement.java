package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.DAO.ITelefonoDao;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Telefono;
import com.darkcode.apirest.services.services.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefonoServiceImplement implements ITelefonoService {

    @Autowired
    private ITelefonoDao telefonoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Telefono> findAll() { return (List<Telefono>)telefonoDao.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Telefono findById(Long id) { return telefonoDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Telefono save(Telefono telefono) { return telefonoDao.save(telefono); }

    @Override
    @Transactional
    public void delete(Long id) { telefonoDao.deleteById(id); }

    @Override
    @Transactional
    public Cliente findClienteById(Long id) { return clienteDao.findById(id).orElse(null); }

}
