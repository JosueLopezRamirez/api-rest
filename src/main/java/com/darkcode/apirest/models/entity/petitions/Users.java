package com.darkcode.apirest.models.entity.petitions;


public class Users {
	
	private Long id;
	private String username;
	private String password;
	private Long empleado_id;
	private Long categoria;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
        this.username = username;
    }

	public String getPassword() {
		return password;
	}

    public void setPassword(String password) {
        this.password = password;
    }

	public Long getEmpleado_id() { return empleado_id; }

	public void setEmpleado_id(Long empleado_id) { this.empleado_id = empleado_id; }

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Users() {}

	public Users(Long id,String username, String password,Long empleado_id, Long categoria) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.empleado_id = empleado_id;
		this.categoria = categoria;
	}

}
