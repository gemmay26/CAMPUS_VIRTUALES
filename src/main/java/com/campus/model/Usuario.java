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

import com.sun.istack.NotNull;

@Entity
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;
	
	@NotNull
	@Column
	private String nombres;
	
	@NotNull
	@Column
	private String apellidos;
	
	@NotNull
	@Column
	private String documento;
	
	@NotNull
	@Column
	private String contrasenna;
		
	@Column
	private Long fk_idperfil;
	
	@Column
	private Long fk_idgrado;
	
	
    public Long getFk_idperfil() {
		return fk_idperfil;
	}

	public void setFk_idperfil(Long fk_idperfil) {
		this.fk_idperfil = fk_idperfil;
	}

	public Long getFk_idgrado() {
		return fk_idgrado;
	}

	public void setFk_idgrado(Long fk_idgrado) {
		this.fk_idgrado = fk_idgrado;
	}

	public List<Respuesta> getRespuestasList() {
		return respuestasList;
	}

	public void setRespuestasList(List<Respuesta> respuestasList) {
		this.respuestasList = respuestasList;
	}

	@JoinColumn(name = "fk_idperfil", insertable= false, updatable= false)
    @ManyToOne (optional = false)
    private Perfil perfil;

   
    @JoinColumn(name = "fk_idgrado", insertable= false, updatable= false)
    @ManyToOne (optional = false)
    private Grado grado;
	
    @OneToMany (cascade =  CascadeType.ALL, mappedBy = "usuario")
	private List<Respuesta> respuestasList;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
}
