package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.DTO.AsesorNames;
import com.darkcode.apirest.models.entity.Asesor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface IAsesorDao extends CrudRepository<Asesor,Long> {

	//@Query(value = "select a.id, p.nombre,p.apellido from Asesor a inner join empleado e on a.empleado_id = e.id inner join persona p on p.id = e.persona_id",nativeQuery = true)
	//@Query(value = "SELECT new com.darkcode.apirest.DTO.AsesorNames(a.id, p.nombre,p.apellido) from Asesor a join fetch a.empleado e join fetch e.persona p where a.empleado.id = e.id and e.persona.id = p.id")
//	@Procedure(name = "buscarAsesores")
//	public List<AsesorNames> GET_ASESORES_DATOS_PERSONALES();
}
