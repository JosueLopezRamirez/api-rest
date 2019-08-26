package com.darkcode.apirest.controllers;

import com.darkcode.apirest.models.entity.Usuario;
import com.darkcode.apirest.BackendExcellenceApplication;
import com.darkcode.apirest.DTO.UsuarioDTO;
import com.darkcode.apirest.services.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {BackendExcellenceApplication.FrontEnd})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * Metodo para obtener unicamente el id,username,password,categoria de un usuario
	 * Esto para la parte del login, no enviamos el objeto completo, sino los datos necesarios
	 * Para no mandar datos innecesarios al cliente
	 */
	@GetMapping("/findAllUsuarios")
	public List<UsuarioDTO> findAllUsers(){
		return (List<UsuarioDTO>) usuarioService.findAllUsers();
	}

	//Obtener todos los usuarios con su formato objeto Java
	@GetMapping("/usuarios")
	public List<Usuario> select() {
		return (List<Usuario>) usuarioService.findAll();
	}

	//Metodo para obtener un usuario de la base de datos por su id
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id){
		return usuarioService.findById(id);
	}

	//Metodo para insertar un usuario a la base de datos
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody UsuarioDTO user){
		//Creando usuario temporal y pasando los parametros del user recibido
		Usuario usuario = new Usuario();
		usuario.setUsername(user.getUsername());
		usuario.setPassword(user.getPassword());
		usuario.setCategoria(user.getCategoria());
		/** Asignandole el objeto empleado completo haciendo uso del IempleadoDao que esta dentro de usuarioService,
		 * para pasarle el ultimo usuario empleado ingresado*/
		usuario.setEmpleado(usuarioService.findEmployeeById(user.getEmpleado_id()));
		return usuarioService.save(usuario);
	}

	//Metodo para actualizar ciertos campos de un usuairo en la base de datos
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody UsuarioDTO user, @PathVariable Long id) {
		/*
		* Asignando los valores del usuario enviado por el cliente a un objeto temporal
		* esto para luego ser enviado a la base datos
		* */
		Usuario usuarioActual = usuarioService.findById(id);
		usuarioActual.setUsername(user.getUsername());
		usuarioActual.setPassword(user.getPassword());
		usuarioActual.setCategoria(user.getCategoria());
		//Metodo save del service al tener un id, usara un merge lo cual se traducira a un update a la base de datos
		return usuarioService.save(usuarioActual);
	}

	//Metodo para eliminar un usuario de la base de datos
	@DeleteMapping ("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		usuarioService.delete(id);
	}
}
