package com.darkcode.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "organizacion")
public class Organizacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombreOrganizacion", length = 50, nullable = false,unique = true)
	private String nombreOrganizacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public Organizacion() {}

	public Organizacion(Long id,String nombreOrganizacion) {
		this.id = id;
		this.nombreOrganizacion = nombreOrganizacion;
	}
}
