package com.darkcode.apirest.services.implement;

import java.util.List;

import com.darkcode.apirest.models.DAO.IEmpleadoDao;
import com.darkcode.apirest.models.DAO.IUsuarioDao;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Usuario;
import com.darkcode.apirest.DTO.UsuarioDTO;
import com.darkcode.apirest.services.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAllUsers() {
		return (List<UsuarioDTO>) usuarioDao.findAllUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
    public Empleado findEmployeeById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario){
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}
}
