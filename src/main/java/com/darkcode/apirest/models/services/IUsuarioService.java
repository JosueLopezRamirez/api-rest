package com.darkcode.apirest.models.services;

import java.util.List;

import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Usuario;
import com.darkcode.apirest.models.entity.petitions.Users;

public interface IUsuarioService {

	public List<Users> findAllUsers();

    public List<Usuario> findAll();

	public Usuario findById(Long id);

	public Usuario save(Usuario usuario);

	public void delete(Long id);

    public Empleado findEmployeeById(Long id);
}
