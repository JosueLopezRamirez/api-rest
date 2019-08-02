package com.darkcode.apirest.models.services.implement;

import com.darkcode.apirest.models.dao.ITutorDao;
import com.darkcode.apirest.models.entity.Tutor;
import com.darkcode.apirest.models.services.services.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutorServiceImplement implements ITutorService {

    @Autowired
    private ITutorDao tutorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tutor> findAll() { return (List<Tutor>) tutorDao.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Tutor findById(Long id) { return tutorDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Tutor save(Tutor tutor) { return tutorDao.save(tutor); }

    @Override
    @Transactional
    public void delete(Long id) { tutorDao.deleteById(id); }
}
