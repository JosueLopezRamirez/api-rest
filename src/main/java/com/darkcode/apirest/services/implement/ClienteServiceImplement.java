package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.dao.IClienteDao;
import com.darkcode.apirest.models.dao.IPersonaDao;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Persona;
import com.darkcode.apirest.services.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImplement implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public Persona findPersonById(Long id) {
        return personaDao.findById(id).orElse(null);
    }
}
