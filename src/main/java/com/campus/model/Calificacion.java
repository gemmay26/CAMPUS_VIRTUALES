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
@Table(name="calificaciones")

public class Calificacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalificaciones;
	
	@Column
	private Long nota;
	
	@Column
	private Long fk_idrespuesta;
	
	@JoinColumn(name = "fk_idrespuesta", insertable= false, updatable= false)
	@ManyToOne (optional = false)
	private Respuesta respuesta;

	public Long getFk_idrespuesta() {
		return fk_idrespuesta;
	}

	public void setFk_idrespuesta(Long fk_idrespuesta) {
		this.fk_idrespuesta = fk_idrespuesta;
	}

	public Long getIdcalificaciones() {
		return idcalificaciones;
	}

	public void setIdcalificaciones(Long idcalificaciones) {
		this.idcalificaciones = idcalificaciones;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
	@Override
	public String toString() {
		return "Calificacion [idcalificaciones=" + idcalificaciones + ", nota=" + nota + ", fk_idrespuesta="
				+ fk_idrespuesta + ", respuesta=" + respuesta + "]";
	}
}
