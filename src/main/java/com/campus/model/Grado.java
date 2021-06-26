package com.campus.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="grados")
public class Grado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgrado;
	
	@Column
	private String descripcion;

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

	@Override
	public String toString() {
		return "Grado [idgrado=" + idgrado + ", descripcion=" + descripcion + "]";
	}
}
