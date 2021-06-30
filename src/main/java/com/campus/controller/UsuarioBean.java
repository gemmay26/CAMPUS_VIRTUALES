package com.campus.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import com.campus.dao.UsuarioDAO;
import com.campus.model.Usuario;

@ManagedBean(name= "usuarioBean")
@RequestScoped
public class UsuarioBean {

	//MENU
	public String home() {
		return "/faces/index.xhtml";
	}
	public String gestion_alumnos() {
		return "/faces/gestion_alumnos/index.xhtml";
	}
	public String gestion_aulas() {
		return "/faces/gestion_aulas/index.xhtml";
	}
	public String gestion_cursos() {
		return "/faces/gestion_cursos/index.xhtml";
	}
	public String gestion_calificaciones() {
		return "/faces/gestion_calificaciones/index.xhtml";
	}
	//////
	
	public String nuevo() {
		Usuario u = new Usuario();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		return "/faces/gestion_alumnos/nuevo.xhtml";
	}
	
	public String guardar(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.guardar(usuario);
		return "/faces/gestion_alumnos/index.xhtml";
	}
	
	public List<Usuario> obtenerUsuarios(){
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		return usuarioDAO.obtenerUsuarios();
	}
	
	public String editar(Long idusuario) {
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		Usuario u = new Usuario();
		u = usuarioDAO.buscar(idusuario);
		System.out.println("***************************");
		System.out.println(u);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		return "/faces/gestion_alumnos/editar.xhtml";
	}
	
	public String asignar(Long idusuario) {
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		Usuario u = new Usuario();
		u = usuarioDAO.buscar(idusuario);
		System.out.println("***************************");
		System.out.println(u);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		return "/faces/gestion_alumnos/asignar.xhtml";
	}
	
	public String actualizar(Usuario usuario) {
		UsuarioDAO usuarioDAO =new UsuarioDAO();
		usuarioDAO.editar(usuario);
		return "/faces/gestion_alumnos/index.xhtml";
	}
	
	public String eliminar(Long idusuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.eliminar(idusuario);
		System.out.println("Usuario eliminado...");
		return "/faces/gestion_alumnos/index.xhtml";
	}
	
}
