package com.darkcode.apirest.models.dao;

import java.util.List;

import com.darkcode.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.darkcode.apirest.models.entity.petitions.Users;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

    //@Query("select u from Usuario u join fetch u.empleado e join fetch e.persona p where u.id = ?1")
    //public Usuario fecthByIdWithEmpleadoWithPersona(Long Id);

	@Query(value = "SELECT new com.darkcode.apirest.models.entity.petitions.Users(u.id,u.username, u.password,u.empleado.id, u.categoria) from Usuario u")
	public List<Users> findAllUsers();
}
