package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.DetalleTutoria;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleTutoriaDao extends CrudRepository<DetalleTutoria, Long> {
	
	@Query(value = "{CALL SP_DETALLE_TUTORIA}",nativeQuery = true)
	public List<Object[]> SP_DETALLE_TUTORIA();
	
}
