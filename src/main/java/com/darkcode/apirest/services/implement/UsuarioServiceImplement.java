package com.darkcode.apirest.services.implement;

import java.util.List;

import com.darkcode.apirest.models.dao.IEmpleadoDao;
import com.darkcode.apirest.models.dao.IUsuarioDao;
import com.darkcode.apirest.models.entity.Empleado;
import com.darkcode.apirest.models.entity.Usuario;
import com.darkcode.apirest.models.entity.petitions.Users;
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


	/*@Override
	@Transactional(readOnly = true)
	public List<Object> fecthByIdWithEmpleadoWithPersona() {
		return (List<Object>)usuarioDao.fecthByIdWithEmpleadoWithPersona();
	}*/

	@Override
	@Transactional(readOnly = true)
	public List<Users> findAllUsers() {
		return (List<Users>) usuarioDao.findAllUsers();
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
