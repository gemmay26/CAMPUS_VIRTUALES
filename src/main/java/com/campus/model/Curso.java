package com.campus.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cursos")

public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcurso;
	
	@Column
	private String descripcion;
	
	@Column
	private Long fk_idgrado;
	
	@JoinColumn(name = "fk_idgrado", insertable= false, updatable= false)
    @ManyToOne (optional = false)
    private Grado grado;
	
	@OneToMany (cascade =  CascadeType.ALL, mappedBy = "curso")
	private List<Actividad> actividadesList;
	
	public Long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Long idcurso) {
		this.idcurso = idcurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getFk_idgrado() {
		return fk_idgrado;
	}

	public void setFk_idgrado(Long fk_idgrado) {
		this.fk_idgrado = fk_idgrado;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public List<Actividad> getActividadesList() {
		return actividadesList;
	}

	public void setActividadesList(List<Actividad> actividadesList) {
		this.actividadesList = actividadesList;
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + idcurso + ", descripcion=" + descripcion + ", fk_idgrado=" + fk_idgrado + ", grado="
				+ grado + ", actividadesList=" + actividadesList + "]";
	}
}
