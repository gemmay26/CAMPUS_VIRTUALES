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
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column
	private String documento;
	
	@Column
	private String contrasenna;
		
	@Column
	private Long fk_idperfil;
	
	@Column
	private Long fk_idgrado;
	
	
 /*   @ManyToOne
    @JoinColumn(name = "fk_idperfil", insertable = false, updatable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "fk_idgrado", insertable = false, updatable = false)
    private Grado grado;
	*/

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

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombres=" + nombres + ", apellidos=" + apellidos + ", documento="
				+ documento + ", contrasenna=" + contrasenna + ", fk_idperfil=" + fk_idperfil + ", fk_idgrado="
				+ fk_idgrado + "]";
	}
	
}
