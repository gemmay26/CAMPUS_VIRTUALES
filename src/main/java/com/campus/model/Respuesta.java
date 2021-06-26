package com.campus.model;

import java.util.Date;
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
@Table(name="respuestas")
public class Respuesta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrespuesta;
	
	@Column
	private String texto;
	
	@Column
	private Date fecha;
	
	@Column
	private Long fk_idactividad;

	@Column
	private Long fk_idusuario;
	
	@JoinColumn(name = "fk_idactividad", insertable= false, updatable= false)
	@ManyToOne (optional = false)
	private Actividad actividad;

	@JoinColumn(name = "fk_idusuario", insertable= false, updatable= false)
	@ManyToOne (optional = false)
	private Usuario usuario;
	
	@OneToMany (cascade =  CascadeType.ALL, mappedBy = "respuesta")
	private List<Calificacion> calificacionesList;

	public Long getFk_idactividad() {
		return fk_idactividad;
	}

	public void setFk_idactividad(Long fk_idactividad) {
		this.fk_idactividad = fk_idactividad;
	}

	public Long getFk_idusuario() {
		return fk_idusuario;
	}

	public void setFk_idusuario(Long fk_idusuario) {
		this.fk_idusuario = fk_idusuario;
	}
	
	public Long getIdrespuesta() {
		return idrespuesta;
	}

	public void setIdrespuesta(Long idrespuesta) {
		this.idrespuesta = idrespuesta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Calificacion> getCalificacionesList() {
		return calificacionesList;
	}

	public void setCalificacionesList(List<Calificacion> calificacionesList) {
		this.calificacionesList = calificacionesList;
	}

	@Override
	public String toString() {
		return "Respuesta [idrespuesta=" + idrespuesta + ", texto=" + texto + ", fecha=" + fecha + ", fk_idactividad="
				+ fk_idactividad + ", fk_idusuario=" + fk_idusuario + ", actividad=" + actividad + ", usuario="
				+ usuario + ", calificacionesList=" + calificacionesList + "]";
	}
	
}
