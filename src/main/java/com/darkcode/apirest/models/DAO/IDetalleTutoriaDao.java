package com.darkcode.apirest.models.DAO;

import com.darkcode.apirest.models.entity.DetalleTutoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public interface IDetalleTutoriaDao extends CrudRepository<DetalleTutoria, Date> {

    @Query("delete from DetalleTutoria dt where dt.FechaReserva =: fecha and dt.hora =: hora")
    public void delete(@RequestParam("fecha") Date fecha, @RequestParam("hora") Date hora);
}
