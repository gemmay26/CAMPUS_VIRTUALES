package com.campus.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grados")
public class Grado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgrado;
	
	@Column
	private String descripcion;
		
	@OneToMany (cascade =  CascadeType.ALL, mappedBy = "grado")
	private List<Usuario> usuariosList;

	@OneToMany (cascade =  CascadeType.ALL, mappedBy = "grado")
	private List<Grupo> gruposList;
	
	@OneToMany (cascade =  CascadeType.ALL, mappedBy = "grado")
	private List<Curso> cursosList;
	
	public List<Grupo> getGruposList() {
		return gruposList;
	}

	public void setGruposList(List<Grupo> gruposList) {
		this.gruposList = gruposList;
	}

	public Long getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(Long idgrado) {
		this.idgrado = idgrado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuariosList() {
		return usuariosList;
	}

	public void setUsuariosList(List<Usuario> usuariosList) {
		this.usuariosList = usuariosList;
	}
	
}
