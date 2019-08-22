package com.darkcode.apirest.models.DAO;

import java.util.List;

import com.darkcode.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.darkcode.apirest.DTO.UsuarioDTO;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	@Query(value = "SELECT new com.darkcode.apirest.DTO.UsuarioDTO(u.id,u.username, u.password,u.empleado.id, u.categoria) from Usuario u")
	public List<UsuarioDTO> findAllUsers();
}
