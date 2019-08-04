package com.darkcode.apirest.services.services;

import com.darkcode.apirest.models.entity.FormaPago;

import java.util.List;

public interface IFormaService {

    public List<FormaPago> findAll();

    public FormaPago findById(Long id);

    public FormaPago save(FormaPago formaPago);

    public void delete(Long id);
}
