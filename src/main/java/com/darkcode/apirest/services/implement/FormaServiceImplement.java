package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.IFormaDao;
import com.darkcode.apirest.models.entity.FormaPago;
import com.darkcode.apirest.services.services.IFormaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormaServiceImplement implements IFormaService {

    @Autowired
    private IFormaDao formaDao;

    @Override
    @Transactional(readOnly = true)
    public List<FormaPago> findAll() {
        return (List<FormaPago>) formaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FormaPago findById(Long id) {
        return formaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public FormaPago save(FormaPago formaPago) {
        return formaDao.save(formaPago);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        formaDao.deleteById(id);
    }
}
