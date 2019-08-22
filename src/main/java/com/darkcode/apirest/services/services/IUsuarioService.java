package com.darkcode.apirest.services.services;

import java.util.List;

import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Usuario;
import com.darkcode.apirest.DTO.UsuarioDTO;

public interface IUsuarioService {

	public List<UsuarioDTO> findAllUsers();

    public List<Usuario> findAll();

	public Usuario findById(Long id);

	public Usuario save(Usuario usuario);

	public void delete(Long id);

    public Empleado findEmployeeById(Long id);
}
