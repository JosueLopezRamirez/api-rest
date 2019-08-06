package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.models.DAO.ITutoriaDao;
import com.darkcode.apirest.models.entity.Tutoria;
import com.darkcode.apirest.services.services.ITutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutoriaServiceImplement implements ITutoriaService {

    @Autowired
    private ITutoriaDao tutoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tutoria> findAll() { return (List<Tutoria>) tutoriaDao.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Tutoria findById(Long id) { return tutoriaDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Tutoria save(Tutoria tutoria) { return tutoriaDao.save(tutoria); }

    @Override
    @Transactional
    public void delete(Long id) { tutoriaDao.deleteById(id); }
}
