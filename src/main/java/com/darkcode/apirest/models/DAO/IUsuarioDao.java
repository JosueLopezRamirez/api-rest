package com.darkcode.apirest.models.DAO;

import java.util.List;

import com.darkcode.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.darkcode.apirest.DTO.UsuarioDTO;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

    //@Query(value = "select distinct u.username,u.password,e.salario,p.Nombre,p.Apellido from Usuario u inner join empleado e on u.empleado_id = e.id inner join persona p on e.persona_id = p.id",nativeQuery = true)
    //public List<Object> fecthByIdWithEmpleadoWithPersona();

	@Query(value = "SELECT new com.darkcode.apirest.models.entity.DTO.Users(u.id,u.username, u.password,u.empleado.id, u.categoria) from Usuario u")
	public List<UsuarioDTO> findAllUsers();
}
