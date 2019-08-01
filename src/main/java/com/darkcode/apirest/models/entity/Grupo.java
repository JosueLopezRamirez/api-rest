package com.darkcode.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombreGrupo", length = 50, insertable = true, updatable = true, nullable = false)
	private String NombreGrupo;

	@ManyToOne
	private Organizacion organizacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreGrupo() {
		return NombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		NombreGrupo = nombreGrupo;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public Grupo() {}

	public Grupo(String nombreGrupo, Organizacion organizacion) {
		this.NombreGrupo = nombreGrupo;
		this.organizacion = organizacion;
	}
}
