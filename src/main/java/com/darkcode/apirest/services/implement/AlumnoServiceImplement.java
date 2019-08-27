package com.darkcode.apirest.services.implement;

import com.darkcode.apirest.DTO.DatosAlumnos;
import com.darkcode.apirest.DTO.DatosGreen;
import com.darkcode.apirest.DTO.GreenHistorial;
import com.darkcode.apirest.DTO.ReservaAlumno;
import com.darkcode.apirest.models.DAO.IAlumnoDao;
import com.darkcode.apirest.models.DAO.IClienteDao;
import com.darkcode.apirest.models.entity.Alumno;
import com.darkcode.apirest.models.entity.Cliente;
import com.darkcode.apirest.services.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImplement implements IAlumnoService {

    @Autowired
    private IAlumnoDao alumnoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly =  true)
    public List<Alumno> findAll() { return (List<Alumno>) alumnoDao.findAll(); }

    @Override
    @Transactional(readOnly =  true)
    public Alumno findById(String id) { return alumnoDao.findById(id).orElse(null); }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) { return alumnoDao.save(alumno); }

    @Override
    @Transactional
    public void delete(String id) { alumnoDao.deleteById(id); }

    @Override
    @Transactional
    public List<DatosAlumnos> SP_GET_DATOS_ALUMNOS() {
        List<Object[]> lista = alumnoDao.SP_GET_DATOS_ALUMNOS();
        List<DatosAlumnos> listaDevuelta = new ArrayList<>();
        lista.forEach(item -> {
            listaDevuelta.add(
                    new DatosAlumnos(
                            (String) item[0], (BigInteger) item[1],
                            (BigInteger) item[2], (String) item[3],
                            (String) item[4], (String) item[5],
                            (Short) item[6], (Boolean) item[7],
                            (String) item[8], (String) item[9]
                    )
            );
        });

        return listaDevuelta;
    }

    @Override
    @Transactional
    public Cliente findClientById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

	@Override
	@Transactional
	public List<GreenHistorial> SP_GET_HISTORIAL_ACADEMICO(String alumno_id) {
		List<Object[]> lista = alumnoDao.SP_GET_HISTORIAL_ACADEMICO(alumno_id);
		List<GreenHistorial> listaDevuelta = new ArrayList<GreenHistorial>();
		
		lista.forEach(item -> listaDevuelta.add(new GreenHistorial((Short) item[0],(String) item[1],(Boolean) item[2])));
		return listaDevuelta;
	}

	@Override
	@Transactional
	public DatosGreen SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(String nombre) {
		Object[] item = alumnoDao.SP_BUSCAR_ALUMNOS_NOMBRE_COMPLETO(nombre);
		return new DatosGreen((BigInteger)item[0],(String)item[1],(String)item[2]);
	}

	@Override
	@Transactional
	public int ALUMNO_NOMBRE_COMPLETO_EXISTE(String nombre) {
		return alumnoDao.ALUMNO_NOMBRE_COMPLETO_EXISTE(nombre);
	}

    @Override
    @Transactional
    public List<ReservaAlumno> SP_LISTA_ALUMNOS_RESERVA(String fecha, String hora) {
        List<Object[]> lista = alumnoDao.SP_LISTA_ALUMNOS_RESERVA(fecha,hora);
        List<ReservaAlumno> listaDevuelta = new ArrayList<>();

        lista.forEach(item -> {
            listaDevuelta.add(
                    new ReservaAlumno((String)item[0],(String)item[1],
                            (boolean)item[2],(Short)item[3]
                    )
            );
        });
        return listaDevuelta;
    }
}
