package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.dao.IClienteDao;
import com.darkcode.apirest.models.dao.ICorreoDao;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.models.entity.Correo;
import com.darkcode.apirest.services.services.ICorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CorreoServiceImplement implements ICorreoService {

    @Autowired
    private ICorreoDao correoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Correo> findAll() { return (List<Correo>)correoDao.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Correo findById(Long id) { return correoDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Correo save(Correo correo) { return correoDao.save(correo); }

    @Override
    @Transactional
    public void delete(Long id) { correoDao.deleteById(id); }

    @Override
    @Transactional
    public Cliente findClienteById(Long id) { return clienteDao.findById(id).orElse(null); }
}
