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
@Table(name="grupos")
public class Grupo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgrupo;
	
	@Column
	private String descripcion;
	
	@Column
	private String fk_idgrado;

	public Long getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFk_idgrado() {
		return fk_idgrado;
	}

	public void setFk_idgrado(String fk_idgrado) {
		this.fk_idgrado = fk_idgrado;
	}

	@Override
	public String toString() {
		return "Grupo [idgrupo=" + idgrupo + ", descripcion=" + descripcion + ", fk_idgrado=" + fk_idgrado + "]";
	}
}
