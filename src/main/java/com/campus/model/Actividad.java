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

import com.sun.istack.NotNull;

@Entity
@Table(name="actividades")

public class Actividad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idactividad;
	
	@NotNull
	@Column
	private Date fecha;
	
	@NotNull
	@Column
	private String titulo;

	@NotNull
	@Column
	private String descripcion;
	
	@Column
	private Long fk_idgrupo;
	
	@Column
	private Long fk_idcurso;
	
	@JoinColumn(name = "fk_idgrupo", insertable= false, updatable= false)
    @ManyToOne (optional = false)
    private Grupo grupo;

   
    @JoinColumn(name = "fk_idcurso", insertable= false, updatable= false)
    @ManyToOne (optional = false)
    private Curso curso;

    @OneToMany (cascade =  CascadeType.ALL, mappedBy = "actividad")
	private List<Respuesta> respuestasList;
    
    public List<Respuesta> getRespuestasList() {
		return respuestasList;
	}
    
	public void setRespuestasList(List<Respuesta> respuestasList) {
		this.respuestasList = respuestasList;
	}


	public Long getFk_idgrupo() {
		return fk_idgrupo;
	}

	public void setFk_idgrupo(Long fk_idgrupo) {
		this.fk_idgrupo = fk_idgrupo;
	}

	public Long getFk_idcurso() {
		return fk_idcurso;
	}

	public void setFk_idcurso(Long fk_idcurso) {
		this.fk_idcurso = fk_idcurso;
	}

	public Long getIdactividad() {
		return idactividad;
	}


	public void setIdactividad(Long idactividad) {
		this.idactividad = idactividad;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "Actividad [idactividad=" + idactividad + ", fecha=" + fecha + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", fk_idgrupo=" + fk_idgrupo + ", fk_idcurso=" + fk_idcurso + ", grupo=" + grupo
				+ ", curso=" + curso + ", respuestasList=" + respuestasList + "]";
	}
}
